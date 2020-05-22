String url ="http://<user name>:<apitoken for user>@localhost:8081/api/xml";
    String name = "admin";
    String password = "admin";
    String authString = name + ":" + password;
    String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
    System.out.println("Base64 encoded auth string: " + authStringEnc);
    Client restClient = Client.create();
    WebResource webResource = restClient.resource(url);
    ClientResponse resp = webResource.accept("application/xml")
                                     .header("Authorization", "Basic " + authStringEnc)
                                     .get(ClientResponse.class);
    if(resp.getStatus() != 200){
        System.err.println("Unable to connect to the server");
    }
    String output = resp.getEntity(String.class);
    System.out.println("response: "+output);