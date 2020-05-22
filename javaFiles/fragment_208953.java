String host ="myHost";
int port = 1234;
HashMap map = new HashMap();
String[] credentials = new String[2];
credentials[0] = user;
credentials[1] = password;
map.put("jmx.remote.credentials", credentials);
JMXConnector c = JMXConnectorFactory.newJMXConnector(createConnectionURL(host, port), map);
c.connect();
Object o = c.getMBeanServerConnection().getAttribute(new ObjectName("java.lang:type=Memory"), "HeapMemoryUsage");
CompositeData cd = (CompositeData) o;
System.out.println(cd.get("committed"));

private static JMXServiceURL createConnectionURL(String host, int port) throws MalformedURLException
{
    return new JMXServiceURL("rmi", "", 0, "/jndi/rmi://" + host + ":" + port + "/jmxrmi");
}