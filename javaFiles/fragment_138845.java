Runtime.getRuntime().exec(new String[] { 
  "/bin/bash", "-c",
  "(" + 
    System.getProperty("catalina.home") + "/bin/shutdown.sh && " +          
    System.getProperty("catalina.home") + "/bin/startup.sh" +
  ") > ~/restart.log 2>&1 &"
});