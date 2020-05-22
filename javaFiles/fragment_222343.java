@Test
public void testJsonMap() throws JsonParseException, JsonMappingException, IOException {
    String json = "{\"number\":\"8119123912\",\"msg\":\"Hello world\"}";
    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String,Object>>() { });
    System.out.println("number:" + map.get("number") + " msg:" + map.get("msg"));
}