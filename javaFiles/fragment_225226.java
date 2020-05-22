/**
 * Returns the ldap context.
 * 
 * @param user the user name
 * @param password the password
 * @return the prepared context
 * @throws NamingException in case of...
 */
protected LdapContext buildContext(final String user, final String password) throws NamingException {
    String providerURL = new StringBuffer(getLdapScheme()) //
            .append("://") //
            .append(getLdapHost()) //
            .append(":") //
            .append(getLdapPort()) //
            .append("/") //
            .append(getLdapRootDN()).toString();

    Hashtable<String, String> properties = new Hashtable<>();
    properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

    properties.put(Context.PROVIDER_URL, providerURL);

    if (!isEmpty(user)) {
        // basic authentication
        properties.put(Context.SECURITY_AUTHENTICATION, "simple");
        properties.put(Context.SECURITY_PRINCIPAL, user);
        properties.put(Context.SECURITY_CREDENTIALS, defaultIfEmpty(password, ""));
    } else {
        // anonymous connection
        properties.put(Context.SECURITY_AUTHENTICATION, "none");
    }

    Control[] controls = null;

    LOGGER.info("creating new ldap context [url:{}, user: {}]", providerURL, user);

    return new InitialLdapContext(properties, controls);
}