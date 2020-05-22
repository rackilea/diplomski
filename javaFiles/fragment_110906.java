REM # Set the Environment (32-bit/64-bit) 

SET JAVA_32_64=64 


REM # Recommended memory settings for 32-bit Java; Default Test, Default Prod 

SET "MCK_MEM_32_OPTS=-server -Xms1024m -Xmx1024m -Xmn256m -XX:MaxPermSize=200m" 



REM # Recommended memory settings for 64-bit Java; Default Test, Default Prod 

SET "MCK_MEM_64_OPTS=-server -Xms2048m -Xmx2048m -Xmn512m -XX:MaxPermSize=300m 


REM # Configure Specific JVM Settings 

SET "MCK_GC_OPTS=-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:%CATALINA_HOME%/logs/gclog.log -verbose:gc -Xbatch -XX:HeapDumpPath=%CATALINA_HOME%/logs -XX:ErrorFile=%CATALINA_HOME%/logs -XX:+TraceClassLoading -XX:+TraceClassUnloading -Djava.awt.headless=true" 



REM # Configure Application Home Directories 

SET "JDK_HOME=C:\Program Files\Java" 

SET "JAVA_32_HOME=%JDK_HOME%\jdk1.6.0_32" 

SET "JAVA_64_HOME=%JDK_HOME%\jdk1.6.0_32" 

SET "JRE_32_HOME=%JAVA_32_HOME%\jre" 

SET "JRE_64_HOME=%JAVA_64_HOME%\jre" 




:64BIT 

SET "MCK_MEM_OPTS=%MCK_MEM_64_OPTS%" 

SET "JAVA_HOME=%JAVA_64_HOME%" 

SET "JRE_HOME=%JRE_64_HOME%" 

goto :CONTINUE 



:CONTINUE 

REM # Specify Memory Options for JBoss JVM 

SET "JAVA_OPTS=%JAVA_OPTS% %MCK_MEM_OPTS% " 



ECHO. 

ECHO =============================================================================== 

ECHO SETENV.BAT 

ECHO =============================================================================== 

ECHO. 

ECHO Running with the following Environment variables: 

ECHO. 

ECHO MCK_MEM_OPTS = %MCK_MEM_OPTS% 

ECHO JAVA_HOME = %JAVA_HOME% 

ECHO JRE_HOME = %JRE_HOME% 

ECHO JAVA_OPTS = %JAVA_OPTS% 

ECHO. 

ECHO =============================================================================== 

ECHO.