@Configuration
public class SolrContext {

  private static final String PROPERTY_NAME_SOLR_SERVER_URL = "solr.host";

  @Resource
  private Environment environment;

  // Factory creates SolrServer instances for base url when requesting server
  // for specific core. 
  @Bean
  public SolrServerFactory solrServerFactory() {
    return new MulticoreSolrServerFactory(new HttpSolrServer(
            environment.getRequiredProperty(PROPERTY_NAME_SOLR_SERVER_URL)));
  }

  // SolrTemplate for /solrServerUrl/towns
  @Bean
  public SolrTemplate townTemplate() throws Exception {
    SolrTemplate solrTemplate = new SolrTemplate(solrServerFactory());
    solrTemplate.setSolrCore("towns");
    return solrTemplate;
  }

  // SolrTemplate for /solrServerUrl/events
  @Bean
  public SolrTemplate eventTemplate() throws Exception {
    SolrTemplate solrTemplate = new SolrTemplate(solrServerFactory());
    solrTemplate.setSolrCore("events");
    return solrTemplate;
  }

  @Bean
  public EventRepository eventRepository() throws Exception {
    return new SolrRepositoryFactory(eventTemplate())
      .getRepository(EventRepository.class, new EventRepositoryImpl(eventTemplate()));
  }

  @Bean
  public TownRepository townRepository() throws Exception {
    return new SolrRepositoryFactory(townTemplate())
      .getRepository(TownRepository.class, new TownRepositoryImpl(townTemplate()));
  }
}