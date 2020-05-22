try{
    String location = "http://localhost:" + port + "/check-person";
    System.out.println(location);
    HttpResponse<JsonNode> jsonResponse =
    Unirest.post("http://localhost:" + port + "/check-person")
    .header("Content-Type", "application/json")
    .body("{\"personName\": \"Darth Vader\"}")
    .asJson();
    assertEquals(403, jsonResponse.getStatus());
} catch(UnirestException e){
    e.printStackTrace();
    System.out.println(e);
}