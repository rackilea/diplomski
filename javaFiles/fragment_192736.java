@Configuration
@Profile( Strings.Profiles.EMBEDDED )
class EmbeddedConfig extends Neo4jConfiguration {

    @Bean
    @Override
    @Scope( value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS )
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
        return new SessionFactory( Strings.PackagePaths.getModelPackages() );
    }
}