@Value("${spring.data.neo4j.uri}")
private String databaseUrl;

@Value("${spring.data.neo4j.username}")
private String userName;

@Value("${spring.data.neo4j.password}")
private String password;

@Bean
public SessionFactory sessionFactory() {
    Configuration configuration = new Configuration.Builder()
            .uri(databaseUrl)
            .credentials(userName, password)
            .build();
    return new SessionFactory(configuration, "com.lapots.tree.model.domain.graph");
}