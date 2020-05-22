ClientConfig config = new DefaultClientConfig();
Client client = Client.create(config);
WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/api").build());

Form f = new Form();    
f.add("userId", "foo");    
f.add("deviceId", "bar");    
f.add("comments", "Device");