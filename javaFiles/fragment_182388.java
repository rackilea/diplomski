Hashtable env = new Hashtable();
env.put(Context.INITIAL_CONTEXT_FACTORY,"com.ibm.websphere.naming
.WsnInitialContextFactory");
env.put(Context.PROVIDER_URL,"corbaloc::boris:9811,:natasha
:9812");
Context ctx = new InitialContext(env);
TestEJBHome home = (TestEJBHome)
PortableRemoteObject.narrow(ctx.lookup("ejb/ejbs/TestEJBHome"),
    TestEJBHome.class);
TestEJB bean = home.create();