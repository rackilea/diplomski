final String json = "{\"contentType\": \"foo\", \"fooField1\": ... }";
final ObjectNode node = new ObjectMapper().readValue(json, ObjectNode.class);
//                              ^ 
// actually, try and *reuse* a single instance of ObjectMapper

if (node.has("contentType")) {
    System.out.println("contentType: " + node.get("contentType"));
}