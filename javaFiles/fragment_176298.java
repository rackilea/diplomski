@Override
protected DirContext bindAsUser(String username, String password) {
    final String bindUrl = url; //super reference
    Hashtable<String,String> env = new Hashtable<String,String>();
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    //String bindPrincipal = createBindPrincipal(username);
    String bindPrincipal = "NT_DOMAIN\\" + username; //the bindPrincipal() method builds the principal name incorrectly
    env.put(Context.SECURITY_PRINCIPAL, bindPrincipal);
    env.put(Context.PROVIDER_URL, bindUrl);
    env.put(Context.SECURITY_CREDENTIALS, password);
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxtFactory");
    //and finally, this simple addition
    env.put(Context.SECURITY_PROTOCOL, "tls");

    //. . . try/catch portion left alone
}