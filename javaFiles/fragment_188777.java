try {
    Client client = Client.create();
    WebResource webResource = client
       .resource("http://localhost:8080/your_app_name/retrieve/some/text");
    ClientResponse response = webResource.accept("application/json")
               .post(ClientResponse.class);
    String output = response.getEntity(String.class);
    System.out.println(output);

  } catch (Exception e) {

    e.printStackTrace();

  }