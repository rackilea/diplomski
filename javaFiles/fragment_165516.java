ClientResponse clientResponse = service.path("api")
                                .path("v1")
                                .path("personal")
                                .path("orders")
                                .path(num)
                                .path("status.json")
                                .accept(MediaType.APPLICATION_JSON)
                                .header("content-type", MediaType.APPLICATION_JSON)
                                .post(ClientResponse.class, jaxbOst);