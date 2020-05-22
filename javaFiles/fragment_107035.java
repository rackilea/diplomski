jconsole -J-Djava.class.path=%JAVA_HOME%/lib/jconsole.jar;
                         %JAVA_HOME%/lib/tools.jar;
                         %WLP_HOME%/clients/restConnector.jar
     -J-Djavax.net.ssl.trustStore=key.jks 
     -J-Djavax.net.ssl.trustStorePassword=Liberty 
     -J-Djavax.net.ssl.trustStoreType=jks