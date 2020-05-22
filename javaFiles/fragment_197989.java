JMXServiceURL url = ...;
Map env = ...;
String[] creds = {"monitorRole", "mrpasswd"};
env.put(JMXConnector.CREDENTIALS, creds);
JMXConnector cc = JMXConnectorFactory.connect(url, env);
MBeanServerConnection mbsc = cc.getMBeanServerConnection();