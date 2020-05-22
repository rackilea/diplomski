final String txUri = SERVER_ROOT_URI + "transaction/commit";
WebResource resource = Client.create().resource( txUri );

String payload = "{\"statements\" : [ {\"statement\" : \"" +query + "\"} ]}";
ClientResponse response = resource
        .accept( MediaType.APPLICATION_JSON )
        .type( MediaType.APPLICATION_JSON )
        .entity( payload )
        .post( ClientResponse.class );