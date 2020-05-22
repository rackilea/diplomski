set JAVA_HOME=C:\tools\jdk1.6.0_19
set WS7_HOME=C:/tools/WebSphere/AppServer
set WS_HOST=127.0.0.1
set WS_PORT=2809

set BOOTPATH=%WS7_HOME%/java/jre/lib/ibmorbapi.jar;%WS7_HOME%/java/jre/lib/ibmorb.jar;%WS7_HOME%/java/jre/lib/ibmcfw.jar
set CLASSPATH=%WS7_HOME%/runtimes/com.ibm.ws.admin.client_7.0.0.jar;%JAVA_HOME%\lib\tools.jar;%JAVA_HOME%\lib\jconsole.jar

%JAVA_HOME%\bin\jconsole -J-Xbootclasspath/p:%BOOTPATH% -J-Djava.class.path=%CLASSPATH% service:jmx:iiop://%WS_HOST%:%WS_PORT%/jndi/JMXConnector