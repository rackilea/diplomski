try {
    Client client = Client.create();

    WebResource webResource = client.resource(http://<your URI>);

    // POST method
    ClientResponse response = webResource.accept("multipart/form-data").type("multipart/form-data").post(ClientResponse.class, "<your XML message>");

    // check response status code
    if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
    }

    // display response
    String output = response.getEntity(String.class);
    System.out.println("Output from Server .... ");
    System.out.println(output + "\n");
} catch (Exception e) {
     e.printStackTrace();
}