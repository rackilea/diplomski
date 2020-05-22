Map<String, String> env = new HashMap<String, String>();
env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
env.put(Context.PROVIDER_URL, "ldap://localhost:389/dc=jayway,dc=se");
env.put(Context.SECURITY_AUTHENTICATION, "simple");
env.put(Context.SECURITY_PRINCIPAL, "uid="+ username +",ou=system"); // replace with user DN
env.put(Context.SECURITY_CREDENTIALS, password);

DirContext ctx;
try {
   ctx = new InitialDirContext(env);
} catch (NamingException e) {
   // handle
}
try {
   SearchControls controls = new SearchControls();
   controls.setSearchScope( SearchControls.SUBTREE_SCOPE);
   ctx.search( "", "(objectclass=person)", controls);
   // no need to process the results
} catch (NameNotFoundException e) {
   // The base context was not found.
   // Just clean up and exit.
} catch (NamingException e) {
   // exception handling
} finally {
   // close ctx or do Java 7 try-with-resources http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
}