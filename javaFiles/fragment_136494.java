@Bean
public FactoryBean getLoginManagerFactory(){
    SimpleRemoteStatelessSessionProxyFactoryBean factory = new SimpleRemoteStatelessSessionProxyFactoryBean();
    String beanName = "jndi.ejb3.LoginManager";
    factory.setJndiName(beanName);
    factory.setBusinessInterface(LoginManager.class);
    Properties p = new Properties();
    p.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory" );
    p.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces" );
    p.setProperty("java.naming.provider.url", "jnp:localhost:1099");
    factory.setJndiEnvironment(p);
return factory;
}