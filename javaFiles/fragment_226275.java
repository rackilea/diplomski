@Test
public void test() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();

    Data data = mapper.readValue("{\"users\": {\"John\": {\"id\": 20}, \"Pete\": {\"id\": 30}}}", Data.class);

    assertEquals(20, data.users.get("John").id);
    assertEquals(30, data.users.get("Pete").id);
    assertEquals("John", data.users.get("John").name);
    assertEquals("Pete", data.users.get("Pete").name);
}

public static class Data {
    @JsonDeserialize(contentUsing = Deser.class)
    public Map<String, User> users;
}

public static class User {
    public String name;
    public int id;
}

public static class Deser extends JsonDeserializer<User> {

    @Override
    public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String name = ctxt.getParser().getCurrentName();

        User user = p.readValueAs(User.class);

        user.name = name;  // This copies the key name to the user object

        return user;
    }
}