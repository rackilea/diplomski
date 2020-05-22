@Bean
public SessionFactory getSessionFactory() {
    return new SessionFactory(getConfiguration(), "com.mycompany.myapp");
}

@Bean
public Neo4jOperations neo4jTemplate() throws Exception {
    return new Neo4jTemplate(getSession());
}

@Bean
public org.neo4j.ogm.config.Configuration getConfiguration() {
    org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();

    config.driverConfiguration().setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
            .setURI("http://localhost:7474")
            .setCredentials("neo4j", "1234");

    return config;
}

@Bean
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public Session getSession() throws Exception {
    return super.getSession();
}