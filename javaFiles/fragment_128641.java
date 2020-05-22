JmxClient client = new JmxClient(hostName, port);
Set<ObjectName> objectNames = getBeanNames() 
for (ObjectName name : objectNames) {
    MBeanAttributeInfo[] attributes = getAttributesInfo(name);
    MBeanOperationInfo[] operations = getOperationsInfo(name);
}