Properties properties = new Properties();
properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
properties.put("java.naming.provider.url", "jnp://localhost:1099");
properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");

InitialContext context = new InitialContext(properties);