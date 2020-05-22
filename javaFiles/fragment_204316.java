ObjectName objectName =new ObjectName("com.sun.management:type=DiagnosticCommand");
MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();

String operationName = "vmFlags";
Object[] params = new Object[1];
String[] signature = new String[]{String[].class.getName()};

String result = (String) mbeanServer.invoke(objectName, operationName, 
                params, signature);

System.out.printf("%s: %s%n", operationName, result);