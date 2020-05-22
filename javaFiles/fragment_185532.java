@ECHO OFF
SETLOCAL ENABLEDELAYEDEXPANSION
:: first get timestamp of this script
SETLOCAL
FOR /F "skip=1 tokens=2-4 delims=(-)" %%a IN ('"echo.|date"') DO (
    FOR /F "tokens=1-3 delims=/.- " %%A IN ("%DATE:* =%") DO (
        SET %%a=%%A&SET %%b=%%B&SET %%c=%%C))
SET /A "yy=10000%yy% %%10000,mm=100%mm% %% 100,dd=100%dd% %% 100"
FOR /F "tokens=1-4 delims=:. " %%A IN ("%time: =0%") DO @SET \
UNIQUE=%yy%%mm%%dd%-%%A%%B

SET TITLE=Schema Crawler
TITLE=%TITLE%
:: supports DBNAME as argument
IF NOT "%1"=="" (
  SET DBNAME=%1
  C:\JDK\bin\java.exe -classpath jtds-1.2.4.jar;schemacrawler-8.8.jar; \
  schemacrawler-sqlserver-8.8.jar schemacrawler.tools.sqlserver.Main -user=sa \
  -password=password -database=!DBNAME! -schemas=!DBNAME!.dbo.* -port=1433 \
  -host=localhost -table_types=TABLE -command=schema -procedures= \
  -infolevel=lint -loglevel=OFF > !DBNAME!_schema_!UNIQUE!.txt
  GOTO :END
)

:: run minimized
::IF NOT DEFINED PIL (
::    SET PIL=1
 ::   START /MIN "" %~0 %1
 ::   EXIT /B
::)

:: script start
ECHO Working...
OSQL.exe -E -Slocalhost -h-1 -Q"SET NOCOUNT ON;SELECT LTRIM(RTRIM(name)) \
FROM sysdatabases WHERE name NOT IN ('master','tempdb','model','msdb');" \
>dblist.txt
FOR /F "tokens=* delims= " %%I IN (dblist.txt) DO (
  IF NOT "%%I"=="                                                      " (
    SET DBNAME=%%I
    SET DBNAME=!DBNAME: =!
    ECHO !DBNAME!
    C:\JDK\bin\java.exe -classpath jtds-1.2.4.jar;schemacrawler-8.8.jar; \
  schemacrawler-sqlserver-8.8.jar schemacrawler.tools.sqlserver.Main -user=sa \
  -password=password -database=!DBNAME! -schemas=!DBNAME!.dbo.* -port=1433 \
  -host=localhost -table_types=TABLE -command=schema -procedures= \
  -infolevel=lint -loglevel=OFF > !DBNAME!_schema_!UNIQUE!.txt
  )
)
DEL /Q dblist.txt
GOTO :EXIT

:END
ECHO Finished processing %1 .  Closing in 20 seconds...
ECHO.
FOR /l %%a in (20,-1,1) do (TITLE %TITLE% -- closing in %%as&ping \
-n 2 -w 1 127.0.0.1>NUL)

:EXIT
EXIT