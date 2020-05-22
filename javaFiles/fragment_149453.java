DefaultHttpClient httpClient = new DefaultHttpClient();
    String groupId = "groupId1";
     String URL = "http://localhost:8080/"+groupId+"/members/add"
    HttpPost postRequest = new HttpPost(
           URL );

    StringEntity input = new StringEntity("{\"name\":matt,\"from\":\"stackovefflow\"}");
    input.setContentType("application/json");
    postRequest.setEntity(input);

    HttpResponse response = httpClient.execute(postRequest);