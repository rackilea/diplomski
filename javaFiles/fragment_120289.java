public class TimestampSerializer extends JsonSerializer<Timestamp> {

    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public void serialize(Timestamp value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        // get the timestmap in the default timezone
        ZonedDateTime z = value.toInstant().atZone(ZoneId.systemDefault());
        String str = fmt.format(z);

        gen.writeString(str);
    }
}