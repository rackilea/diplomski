/java/jdk1.7.0/jre/bin/java.exe 
-Xbootclasspath/p:/NetBeans/enterprise/modules/ext/javaee6-endorsed/javax.annotation.jar;/NetBeans/enterprise/modules/ext/javaee6-endorsed/jaxb-api-osgi.jar;/NetBeans/enterprise/modules/ext/javaee6-endorsed/webservices-api-osgi.jar 
-Djava.endorsed.dirs=/glassfish410/glassfish/lib/endorsed;/glassfish410/glassfish/modules/endorsed 
-javaagent:/glassfish410/glassfish/lib/gf-client.jar=mode=acscript,arg=-configxml,arg=/glassfish410/glassfish/domains/domain1/config/glassfish-acc.xml,client=jar=dist/EntAppClientClient.jar 
-Djava.system.class.loader=org.glassfish.appclient.client.acc.agent.ACCAgentClassLoader 
-jar /EntAppClient/dist/EntAppClientClient.jar