@Test
public void json3() throws JsonParseException, JsonMappingException, IOException {
    Map<String, JsonNode> store = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper();
    JsonNode users = mapper.readValue(
                    "[{\"name\":\"Peter\",\"ID\":\"bc6fe168-e73f-48c9-b421-ad3c4c424392\", \"Age\":\"23\",\"Comment\":\"I am a new User\"},{\"name\":\"jschnasse\",\"ID\":\"bc6fe168-e73f-48c9-b421-ad3c4c424393\", \"Age\":\"well\",\"Comment\":\"I am a fun User\"}]",
                    JsonNode.class);
    users.forEach((user) -> {
        String id = user.at("/ID").asText();
        if (!store.containsKey(id)) {
            store.put(id, user);
        } else {
            /* Do something else */
        }
    });
    System.out.println(toString(store.values()));
}

public String toString(Object obj) {
    try (StringWriter w = new StringWriter();) {
        new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true).writeValue(w, obj);
        return w.toString();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}