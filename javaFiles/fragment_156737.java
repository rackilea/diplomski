public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss+00:00";

    private final DateTimeFormatter formatter;

    public LocalDateTimeDeserializer() {
        this.formatter = DateTimeFormatter.ofPattern(PATTERN);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return LocalDateTime.parse(p.getText(), formatter);
    }
}