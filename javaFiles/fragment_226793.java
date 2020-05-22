public static boolean performAuthentication() {

    // service user
    String serviceUserDN = "cn=Mister Service,ou=Users,dc=example,dc=com";
    String serviceUserPassword = "abc123#!$";

    // user to authenticate
    String identifyingAttribute = "uid";
    String identifier = "maxdev";
    String password = "jkl987.,-";
    String base = "ou=Users,dc=example,dc=com";

    // LDAP connection info
    String ldap = "localhost";
    int port = 10389;
    String ldapUrl = "ldap://" + ldap + ":" + port;

    // first create the service context
    DirContext serviceCtx = null;
    try {
        // use the service user to authenticate
        Properties serviceEnv = new Properties();
        serviceEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        serviceEnv.put(Context.PROVIDER_URL, ldapUrl);
        serviceEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
        serviceEnv.put(Context.SECURITY_PRINCIPAL, serviceUserDN);
        serviceEnv.put(Context.SECURITY_CREDENTIALS, serviceUserPassword);
        serviceCtx = new InitialDirContext(serviceEnv);

        // we don't need all attributes, just let it get the identifying one
        String[] attributeFilter = { identifyingAttribute };
        SearchControls sc = new SearchControls();
        sc.setReturningAttributes(attributeFilter);
        sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

        // use a search filter to find only the user we want to authenticate
        String searchFilter = "(" + identifyingAttribute + "=" + identifier + ")";
        NamingEnumeration<SearchResult> results = serviceCtx.search(base, searchFilter, sc);

        if (results.hasMore()) {
            // get the users DN (distinguishedName) from the result
            SearchResult result = results.next();
            String distinguishedName = result.getNameInNamespace();

            // attempt another authentication, now with the user
            Properties authEnv = new Properties();
            authEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            authEnv.put(Context.PROVIDER_URL, ldapUrl);
            authEnv.put(Context.SECURITY_PRINCIPAL, distinguishedName);
            authEnv.put(Context.SECURITY_CREDENTIALS, password);
            new InitialDirContext(authEnv);

            System.out.println("Authentication successful");
            return true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (serviceCtx != null) {
            try {
                serviceCtx.close();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
    }
    System.err.println("Authentication failed");
    return false;
}