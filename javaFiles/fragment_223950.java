Hashtable<String, String> env = new Hashtable<>();
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); 
    env.put(Context.PROVIDER_URL, "ldap://xxx.xxx.xxx.xx"); 
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    env.put(Context.SECURITY_PRINCIPAL, "domain\\username");
    env.put(Context.SECURITY_CREDENTIALS, "passwd");
    try {
        DirContext ctx = new InitialDirContext(env);
        System.out.println("Success");
    } catch (Throwable ex) {
        System.out.println("Authentication failed: " + ex);
    }