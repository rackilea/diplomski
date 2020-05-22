public class TimestampDeserializer extends JsonDeserializer<Timestamp> {

    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public Timestamp deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        // parse to a LocalDateTime
        LocalDateTime dt = LocalDateTime.parse(jsonParser.getText(), fmt);
        // the date/time is in the default timezone
        return Timestamp.from(dt.atZone(ZoneId.systemDefault()).toInstant());
    }
}