JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
JMXConnector jmxc = JMXConnectorFactory.connect(url);
MBeanServerConnection conn = jmxc.getMBeanServerConnection();

String operationName="removeQueue"; //operation like addQueue or removeQueue
String parameter="Payment_Check";   // Queue name
ObjectName activeMQ = new ObjectName("org.apache.activemq:brokerName=localhost,type=Broker");
if(parameter != null) {
    Object[] params = {parameter};
    String[] sig = {"java.lang.String"};
    conn.invoke(activeMQ, operationName, params, sig);
} else {
    conn.invoke(activeMQ, operationName,null,null);
}