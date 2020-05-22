JMXServiceURL url = new     JMXServiceURL("service:jmx:rmi:///jndi/rmi://hist:1099/jmxrmi");
JMXConnector jmxc = JMXConnectorFactory.connect(url);
MBeanServerConnection conn = jmxc.getMBeanServerConnection(); 

ObjectName activeMq = new ObjectName("org.apache.activemq:Type=Broker,BrokerName=localhost");

BrokerViewMBean mbean = (BrokerViewMBean)MBeanServerInvocationHandler.newProxyInstance(conn, activeMq, BrokerViewMBean.class, true);
String uri = mbean.getTransportConnectorByType("tcp");// or ("ssl") 
String[] pairs = uri.split("&");
for (String pair : pairs) {
    if (pair.startsWith("wireFormat.maxFrameSize")) {
        int idx = pair.indexOf("=");
        System.out.println(URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
    }
}