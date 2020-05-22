static private void enableLogging(boolean logDriver) 
throws MalformedObjectNameException, NullPointerException, 
       AttributeNotFoundException, InstanceNotFoundException, 
       MBeanException, ReflectionException, InvalidAttributeValueException, 
       SecurityException, FileNotFoundException, IOException 
{
    oracle.jdbc.driver.OracleLog.setTrace(true);

    // compute the ObjectName
    String loader = Thread.currentThread().getContextClassLoader().toString().replaceAll("[,=:\"]+", "");
    javax.management.ObjectName name = new javax.management.ObjectName("com.oracle.jdbc:type=diagnosability,name="+loader);

    // get the MBean server
    javax.management.MBeanServer mbs = java.lang.management.ManagementFactory.getPlatformMBeanServer();

    // find out if logging is enabled or not
    System.out.println("LoggingEnabled = " + mbs.getAttribute(name, "LoggingEnabled"));

    // enable logging
    mbs.setAttribute(name, new javax.management.Attribute("LoggingEnabled", true));

    File propFile = new File("path/to/properties");
    LogManager logManager = LogManager.getLogManager();
    logManager.readConfiguration(new FileInputStream(propFile));

    if (logDriver) {
        DriverManager.setLogWriter(new PrintWriter(System.err));
    }
}