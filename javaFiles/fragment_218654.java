import javax.naming.*;
 private static InitialContext ctx = null;
  ...
  public static InitialContext getInitialContext( ) throws NamingException {
   if (ctx == null) {
    Hashtable env = new Hashtable( );
    env.put(Context.INITIAL_CONTEXT_FACTORY, 
        "weblogic.jndi.WLInitialContextFactory");
    env.put(Context.PROVIDER_URL, 
        "t3://myserver:8001");
    ctx = new InitialContext(env);
   }
 return ctx;
 }