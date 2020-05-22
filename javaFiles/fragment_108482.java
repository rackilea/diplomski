public class CustomDateFormatter extends JsonSerializer<Date> {

    private final DateTimeFormatter formatter;

    public CustomDateFormatter() {
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneOffset.UTC);
    }

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String str = formatter.format(value.toLocalDate());
        gen.writeString(str);
    }
}