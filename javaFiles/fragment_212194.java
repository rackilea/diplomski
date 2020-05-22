LoginRequest loginReq = new LoginRequest();
loginReq.setUserId("admin");
loginReq.setPassword("a");
ClientResponse resp = webResource.path(path)
        .type(MediaType.APPLICATION_JSON)
        .post(ClientResponse.class, loginReq);