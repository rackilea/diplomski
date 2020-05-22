class MyBooleanDeserializer extends JsonDeserializer {
    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return Boolean.parseBoolean(jsonParser.getValueAsString().toLowerCase());
    }
}