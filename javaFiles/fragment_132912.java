Resource resource = client.resource("https://api.com");
String response = resource
    .contentType(MediaType.APPLICATION_JSON)
    .header("Authorization", "Bearer " + accessToken)
    .accept(MediaType.APPLICATION_JSON)
    .post(String.class, payload);
//Parse the String here to turn it into a JSONObject