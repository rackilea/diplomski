public void flushEhcache() throws IOException, NamingException,  MalformedObjectNameException, NullPointerException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, ReflectionException {
    String host = "111.22.3.44";
    String port = "16000";
    JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://"
        + host + ":" + port + "/jmxrmi");
    JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
    MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();        
    ObjectName beanName = new ObjectName("net.sf.ehcache:type=CacheManager,name=Your  Application Name Here");        
    mbsc.invoke(beanName, "clearAll", new Object[0], new String[0]);
    System.out.println("Flushed out ehcache succesfully");
}