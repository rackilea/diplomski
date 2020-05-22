@Bean
public Client client() throws UnknownHostException {
    Settings settings = Settings.builder()
             .put("client.transport.sniff", true)
                .put("cluster.name", "elasticsearch").build();
    @SuppressWarnings("resource")
    TransportClient client = new PreBuiltTransportClient(settings)
    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
     return client;
}

@Bean
public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
    return new ElasticsearchTemplate(client());
}