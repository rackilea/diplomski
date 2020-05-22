// First connect to the remote service
String urlPath = "/jndi/rmi://" + hostname + ":" + port + "/jmxrmi";
JMXServiceURL url = new JMXServiceURL("rmi", "", 0, urlPath);
JMXConnector jmxc = JMXConnectorFactory.connect(url);
MBeanServerConnection server = jmxc.getMBeanServerConnection();

// Then get all threads
ThreadMXBean tmbean = newPlatformMXBeanProxy(server, THREAD_MXBEAN_NAME, ThreadMXBean.class);
ObjectName tmbean = new ObjectName(THREAD_MXBEAN_NAME);
long[] tids = tmbean.getAllThreadIds();
ThreadInfo[] tinfos = tmbean.getThreadInfo(tids, Integer.MAX_VALUE);
for (ThreadInfo ti : tinfos) {
  // do something with this particular thread...
}