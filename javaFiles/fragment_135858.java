@Component
@PropertySource("classpath:propelr.properties")
final class ElasticSearchClientFactory extends 
AbstractFactoryBean<RestHighLevelClient> {

private final RestHighLevelClient client;

ElasticSearchClientFactory(
        final @Value("${elasticsearch.hostname}") String hostname,
        final @Value("${elasticsearch.port}") int port,
        final @Value("${elasticsearch.protocol}") String protocol
) {
    client = new RestHighLevelClient(RestClient.builder(new 
 HttpHost(hostname, port, protocol)));
}

@Override
public Class<?> getObjectType() {
    return RestHighLevelClient.class;
}

@Override
protected RestHighLevelClient createInstance() throws Exception {
    return client;
}

@Override
public void destroy() throws Exception {
    if (Objects.nonNull(client)) {
        client.close();
    }
}
}