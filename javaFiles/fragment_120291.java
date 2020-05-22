public class TimestampSerializer extends JsonSerializer<Timestamp> {

    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public void serialize(Timestamp value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        // get the timestmap in the default timezone
        ZonedDateTime z = DateTimeUtils.toInstant(value).atZone(ZoneId.systemDefault());
        String str = fmt.format(z);

        gen.writeString(str);
    }
}

public class TimestampDeserializer extends JsonDeserializer<Timestamp> {

    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public Timestamp deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        // parse to a LocalDateTime
        LocalDateTime dt = LocalDateTime.parse(jsonParser.getText(), fmt);
        // the date/time is in the default timezone
        return DateTimeUtils.toSqlTimestamp(dt.atZone(ZoneId.systemDefault()).toInstant());
    }
}