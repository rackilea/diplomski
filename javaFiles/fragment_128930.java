MBeanServerConnection mbs;

   // Connect to a running JVM (or itself) and get MBeanServerConnection  // that has the JVM MXBeans registered in it    ...

   try {
       // Assuming the RuntimeMXBean has been registered in mbs
       ObjectName oname = new ObjectName(ManagementFactory.RUNTIME_MXBEAN_NAME);

       // Get standard attribute "VmVendor"
       String vendor = (String) mbs.getAttribute(oname, "VmVendor");   } catch (....) {
       // Catch the exceptions thrown by ObjectName constructor
       // and MBeanServer.getAttribute method
       ...    }