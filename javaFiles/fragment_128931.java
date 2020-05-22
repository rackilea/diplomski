MBeanServerConnection mbs;

   // Connect to a running JVM (or itself) and get MBeanServerConnection  // that has the JVM MBeans registered in it    ...

   // Get a MBean proxy for RuntimeMXBean interface    RuntimeMXBean proxy = 
       ManagementFactory.newPlatformMXBeanProxy(mbs,
                                                ManagementFactory.RUNTIME_MXBEAN_NAME,
                                                RuntimeMXBean.class);    // Get standard attribute "VmVendor"     String vendor = proxy.getVmVendor();