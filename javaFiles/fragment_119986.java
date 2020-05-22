ClientConfig clientConfig = new DefaultClientConfig();
clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, 
                               Boolean.TRUE);
Client client = Client.create(clientConfig);
r = client.resource(Main.BASE_URI);
// r = WebResource