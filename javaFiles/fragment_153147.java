ClientConfig config = new DefaultClientConfig();
Client client = Client.create(config);
WebResource webResource = client.resource("http://some.url/path1/path2");

MultivaluedMapImpl values = new MultivaluedMapImpl();
values.add("filename", "report.zip");
values.add("text", "Test message");
values.add("content", new String(Base64.encode(FileUtils.readFileToByteArray(attachedLogs))));
ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, values);