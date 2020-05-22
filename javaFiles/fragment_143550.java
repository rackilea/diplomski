ClientConfig cc = new DefaultClientConfig();
    cc.getProperties().put(
            ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
    Client c = Client.create(cc);
    WebResource r = c.resource("https://my_url");
    ClientResponse response = r.get(ClientResponse.class);
    EntityTag e = response.getEntityTag();
    String entity = response.getEntity(String.class);
    System.out.println("The response status is " + response.getStatus());
    System.out.println("The enttiy body is " + entity);