HashMap environment = new HashMap();
  String[] credentials = new String[] { "user", "pass" };
  environment.put(JMXConnector.CREDENTIALS, credentials);

  JMXServiceURL url = new JMXServiceURL("URL");

  // Get JMX connector, supplying user name and password
  JMXConnector jmxc1 = JMXConnectorFactory.connect(url, environment);

  // Get MBean server connection
  MBeanServerConnection mbsc = jmxc1.getMBeanServerConnection();

  ObjectName destMgrConfigName = new ObjectName(MQObjectName.DESTINATION_MANAGER_MONITOR_MBEAN_NAME);

  // Create operation's parameter and signature arrays

  Object opParams[] = {};

  String opSig[] = {};

  // Invoke operation
  ObjectName[] objectNames = (ObjectName[]) mbsc.invoke(destMgrConfigName, DestinationOperations.GET_DESTINATIONS, opParams, opSig);

  for (ObjectName objectName : objectNames) {
   System.out.println(objectName.getCanonicalName());
   System.out.println(objectName.getKeyProperty("name"));
  }