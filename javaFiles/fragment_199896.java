String SESSION_NAME_KEY = "SESSIONNAME";
String sessionname = System.getenv(SESSION_NAME_KEY);

if(sessionname != null && 
     (sessionname.startsWith("ICA") || sessionname.startsWith("RDP")))
    //Disable JOGL