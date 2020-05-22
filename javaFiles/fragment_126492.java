class CustomDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.readValueAsTree();       
        return node.toString();
    }

}