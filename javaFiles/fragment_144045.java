echo off

set JAVA_HOME="c:\Program Files\Java\jdk1.6.0_25"

set BUILD_CP=%JAVA_HOME%\lib\tools.jar;..\devlib\ant.jar;..\devlib\optional.jar;..\devlib\junit.jar;..\devlib\xercesImpl.jar;..\devlib\xmlParserAPIs.jar;

%JAVA_HOME%\bin\java -classpath %BUILD_CP% org.apache.tools.ant.Main -buildfile build.xml all

set BUILD_CP=

pause