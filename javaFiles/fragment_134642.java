public static <T> T create(URI resourceUri, Class<T> clazz) {

    ClientConfig clientConfig = new DefaultClientConfig();
    clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
    Client client = Client.create(clientConfig);
    WebResource webResource = client.resource(resourceUri);

    T someData = webResource.accept(MediaType.APPLICATION_XML).get(clazz);

    return someData;        
}