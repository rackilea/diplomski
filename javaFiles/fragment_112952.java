@Configuration
public class Neo4JDevelopmentConfig extends Neo4jConfiguration {

@Bean
@Override
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public Session getSession() throws Exception {
    return super.getSession();
}

@Bean
@Override
public Neo4jServer neo4jServer() {
    return new InProcessServer();
}

@Bean
@Override
public SessionFactory getSessionFactory() {
    return new SessionFactory("com.xenoterracide.rpf");
}
}