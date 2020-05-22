class CustomJacksonDeserialize extends JsonDeserializer<Activity> {
    @Override
    public Activity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException,
            NullPointerException {

        JsonNode jsonNode = jsonParser.readValueAsTree();

        String name=jsonNode.get("results").get(0).get("testing").get("name").asText();

        return new Activity(name);
    }
}