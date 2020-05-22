@Configuration
@ComponentScan("my.services")
@EnableNeo4jRepositories("my.repos")
public class MyTestingConfiguration extends Neo4jConfiguration {

  @Override
  @Bean
  public Neo4jServer neo4jServer() {
    return new InProcessServer();
  }

  @Override
  public SessionFactory getSessionFactory() {
    return new SessionFactory("de.tsbros");
  }
}