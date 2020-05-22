Client client = Client.create();
WebResource webResource = client.resource("http://jsonplaceholder.typicode.com/posts");
ClientResponse response = webResource.accept("application/json")
            .header("user-agent", "")
            .get(ClientResponse.class);
if(response.getStatus() != 200) {
    throw new RuntimeException("Failed http error code :" + response.getStatus());
}
String output = response.getEntity(String.class);
System.out.println(output);