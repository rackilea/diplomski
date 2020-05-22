Resource resource = client.resource("https://api.com/");
ClientResponse response = resource.contentType("application/json")
        .accept("application/json")
        .header("Authorization", "Bearer " + accessToken)
        .post(payload);
JSONObject customerResponseObject = response.getEntity(JSONObject.class);