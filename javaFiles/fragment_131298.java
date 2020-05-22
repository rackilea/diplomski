class GradeDeserializer extends JsonDeserializer<Grade> {
    @Override
    public Grade deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        return Grade.fromString(parser.getValueAsString());
    }
}