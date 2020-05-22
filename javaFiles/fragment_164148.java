ClientConfig config = new DefaultClientConfig();
com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(config);

MultiValueMap formData = new MultiValueMapImpl();
formData.add("key", "value");

WebResource resource = client.resource("http://path/to/resource");
ClientResponse response = resource.type("application/x-www-form-urlencoded").post(ClientResponse.class, formData);