String initialContextUrl = "ldap://myhost:991/c=uk,o=ACME"
  String contextFactory = "com.sun.jndi.ldap.LdapCtxFactory";
  Hashtable environment = new Hashtable();
  environment.put(Context.INITIAL_CONTEXT_FACTORY, contextFactory);
  environment.put(Context.PROVIDER_URL, initialContextUrl);
  Context context = new InitialDirContext(environment);