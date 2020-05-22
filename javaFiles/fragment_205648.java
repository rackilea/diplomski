@echo off
setlocal EnableExtensions EnableDelayedExpansion
title MyProgram
if "%~1" == "/?" goto ShowHelp

rem Try to find java.exe in current folder or any folder defined in
rem environment variable PATH as Windows command interpreter would do.

set "SearchPath=%CD%;%PATH%"
set "SearchPath=%SearchPath:)=^)%"
set "SearchPath=%SearchPath:\;=;%"
for /F "delims=" %%I in ('echo %SearchPath:;=^&ECHO %') do (
    if exist "%%~I\java.exe" (
        set "JavaPath=%%~I"
        goto RunMyProgram
    )
)

echo %~dpn0
echo.
echo Error: Failed to find java.exe in current folder or
echo        any folder defined in environment variable PATH.


:GetJavaPath
echo.
echo Please enter path to folder with java.exe.
echo.
echo Enter nothing to exit if Java is not installed at all.
echo.

set "JavaPath="
set /P "JavaPath=Path to java.exe: "

rem Has the user entered a folder path at all?
if "!JavaPath!" == "" goto BatchExit

rem Remove all double quotes from entered folder path.
set "JavaPath=!JavaPath:"=!"

rem Replace all / by \ in entered folder path.
set "JavaPath=!JavaPath:/=\!"

rem If there is a backslash at end, remove this backslash.
if "!JavaPath:~-1!" == "\" set "JavaPath=!JavaPath:~0,-1!"

rem Does java.exe exist in entered folder path?
if exist "!JavaPath!\java.exe" goto RunMyProgram

echo.
echo There is no java.exe in entered folder.
goto GetJavaPath


:ShowHelp
echo For using this application ...

echo.
pause
goto BatchExit


:RunMyProgram
echo.
"%JavaPath%\java.exe" -cp "%~dp0MyProgram.jar" %*


:BatchExit
endlocal