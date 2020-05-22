//Get the connection
MBeanServerConnection connection = org.jboss.mx.util.MBeanServerLocator.locateJBoss();

//Query for MBeans in the chap2.xmbean namespace
Set<ObjectInstance> mbeans = connection.queryMBeans(null, new ObjectName("chap2.xmbean:service=*"));

//Loop over each MBean and invoke an interface method
for (ObjectInstance mbean : mbeans)
{
    //Invoking 'put' method from example. If this were an info method, this would return the result of the MBean operation
    connection .invoke(mbean.getObjectName(), "put", new Object[] {"TestKey", "TestValue"}, new String[] {Object.class.getName(), Object.class.getName()});
}