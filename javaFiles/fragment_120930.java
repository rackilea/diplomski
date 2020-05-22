public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jsonparser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        String date = jsonparser.getText();

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(javaTimeModule);
        ZonedDateTime zonedDateTime = mapper.readValue(date, ZonedDateTime.class);
        return zonedDateTime.toLocalDateTime();
    }
}