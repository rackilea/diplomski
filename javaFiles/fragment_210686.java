@Bean
public SolrClient solrClient() throws IOException, SolrServerException {
    String folder = "src/main/resources/solr/";
    String coreName = "candidates";
    CoreContainer container = new CoreContainer(folder);
    container.load();
    return new EmbeddedSolrServer(container, coreName);
}