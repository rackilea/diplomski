@SuppressWarnings("serial")
    private static Properties   initProperties() {
        return (new Properties() {{
            // overrides for the JNDI factory
            // mostly changing the INITIAL_CONTEXT_FACTORY from:
            //   "org.jboss.security.jndi.JndiLoginInitialContextFactory"
            // to:
            put(Context.INITIAL_CONTEXT_FACTORY,
                "org.jnp.interfaces.NamingContextFactory");
            put(Context.PROVIDER_URL, "jnp://localhost/");

            // Required JMX properties and other things ...
            //  YMMV of course, these were for my current settings
            put("java.rmi.server.randomIDs", "true");
            put("java.rmi.server.hostname", host); // host needs to be an IP
            put("com.sun.management.jmxremote.ssl", "false");
            put("com.sun.management.jmxremote.authenticate", "false");
            put("com.sun.management.jmxremote.local.only", "true");
            put("com.sun.management.jmxremote.port", String.valueOf(port));
        }});
    }