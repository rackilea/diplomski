@Bean
public JndiTemplate jndiTemplate() {
    Properties props = new Properties();
    props.setProperty(InitialContext.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
    props.setProperty(InitialContext.PROVIDER_URL, "t3://localhost:7001");
    return new JndiTemplate(props);
}