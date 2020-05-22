public void createWeblogicUser() { 
try { 
    Hashtable<String, String> env = new Hashtable<String, String>(); 
    env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory"); 
    env.put(Context.SECURITY_PRINCIPAL, "weblogic"); 
    env.put(Context.SECURITY_CREDENTIALS, "welcome1"); 
    env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101"); 
    InitialContext ctx = new InitialContext(env); 
    MBeanServer wls = (MBeanServer) ctx.lookup("java:comp/env/jmx/runtime"); 
    wls.invoke(new ObjectName(" Security:Name=myrealmDefaultAuthenticator") 
         , "createUser" 
         , new Object[] {"wls_user5555", "password123","User created programmatically."} 
         , new String[] {"java.lang.String", "java.lang.String","java.lang.String"} 
      ); 
    ctx.close();

}
catch(Exception ex) { 
    ex.printStackTrace(); 
} 

}