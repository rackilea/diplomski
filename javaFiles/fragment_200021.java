String jsonString = "{\"results\":[{\"testing\":{\"name\":\"soham\"}},{\"testing\":{\"firstname\":\"john\",\"lastname\":\"don\"}}]}";
    ObjectMapper objectMapper = new ObjectMapper();

JsonNode jsonNode = objectMapper.readTree(jsonString);
JsonNode resultNode=jsonNode.get("results");
String name = resultNode.get(0).get("testing").get("name").asText();

Activity activity=new Activity(name);

String firstName=  resultNode.get(1).get("testing").get("firstname").asText();
String lastName=  resultNode.get(1).get("testing").get("lastname").asText();

Activity2 activity2=new Activity2(firstName, lastName);