MBeanServerConnection serv;
if (hostname != null) {
    //remote connection
    JMXServiceURL u = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + hostname + "/jmxrmi");
    String[] credentials = new String[]{"admin", "adminadmin"};
    Map<String, String[]> environment = new LinkedHashMap<String, String[]>();
    environment.put("jmx.remote.credentials", credentials);

    JMXConnector c = JMXConnectorFactory.connect(u, environment);
    serv = c.getMBeanServerConnection();
} else {
    //local connection
    serv = ManagementFactory.getPlatformMBeanServer();
}

//connect to AMX
DomainRoot dRoot = ProxyFactory.getInstance(serv).getDomainRoot(true) ;

//get the Administrative domain name in the Domain Configuration
Map<String, String> map = dRoot.getDomainConfig().getProperties() ;
System.out.println(map.get("administrative.domain.name"));