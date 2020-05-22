@Configuration
@PropertySource(value = "classpath:config/elasticsearch.properties")
public class ElasticsearchConfiguration {

    @Resource
    private Environment environment;

    @Bean
    public Client client() {
        TransportClient client = new TransportClient();
        TransportAddress address = new InetSocketTransportAddress(
                environment.getProperty("elasticsearch.host"), 
                Integer.parseInt(environment.getProperty("elasticsearch.port"))
        );
        client.addTransportAddress(address);        
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
}