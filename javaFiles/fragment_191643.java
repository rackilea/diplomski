@echo off
:: possible locations under HKLM\SOFTWARE of JavaSoft registry data
set "javaNativeVersion="
set "java32ON64=Wow6432Node\"

:: for variables
::    %%k = HKLM\SOFTWARE subkeys where to search for JavaSoft key
::    %%j = full path of "Java Runtime Environment" key under %%k
::    %%v = current java version
::    %%e = path to java

set "javaDir="
set "javaVersion="
for %%k in ( "%javaNativeVersion%" "%java32ON64%") do if not defined javaDir (
    for %%j in ("HKLM\SOFTWARE\%%~kJavaSoft\Java Runtime Environment"
    ) do for /f "tokens=3" %%v in (
        'reg query "%%~j" /v "CurrentVersion" 2^>nul ^| find /i "CurrentVersion"'
    ) do for /f "tokens=2,*" %%d in (
        'reg query "%%~j\%%v" /v "JavaHome"   2^>nul ^| find /i "JavaHome"'
    ) do ( set "javaDir=%%~e" & set "javaVersion=%%v" )
)

if not defined javaDir (
    echo Java not found
    exit /b 1
) else (
    echo JAVA_HOME=%javaDir%
    set JAVA_HOME=%javaDir%
    PATH %JAVA_HOME%\bin;%PATH%
    java.exe >nul 2>&1 || (
        setx JAVA_HOME %JAVA_HOME%
        setx PATH %PATH%
    )
    echo  JAVA_VERSION=%javaVersion%
)

for /f tokens^=2-5^ delims^=.-_^" %%j in ('java -fullversion 2^>^&1') do @set "jver=%%j%%k%%l%%m"
echo full java version %jver%
if %jver% GTR  16445 (
    echo "Java version is higher MR tool will not able to install"
    exit /b 2
)