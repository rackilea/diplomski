Properties env = new Properties();
env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
env.put(Context.PROVIDER_URL, "jnp://myserver.example.com:1099");
InitialContext context = new InitialContext(env);

Bean bean = (Bean) context.lookup("myear/MyBean/remote");