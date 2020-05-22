// step-1 : set hostName into System's property, which will use by log4j
System.setProperty("hostName", InetAddress.getLocalHost().getHostName()); 
//step - 2 : set currentDate into System's property, which will use by log4j
System.setProperty("currentDate", new SimpleDateFormat("dd-MMM-yyyy").format(new Date()));
//step - 3 : now configure/load log4j into Application , if it's not still loaded earlier then.
org.apache.log4j.Logger LOG = Logger.getLogger(YourJavaClassName.class); // ALERT : before this step above 2-step must needs to be execute, otherwise file-name won't appear as you required.

//LOG.debug("anything whatever programmer what to log");