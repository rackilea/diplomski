private static Context createContextWildfly(String provider) throws NamingException {
    final Hashtable<String, String> properties = new Hashtable<>();
    properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
    properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
    properties.put("jboss.naming.client.ejb.context", "true");  
    properties.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
    return new InitialContext(properties);
}