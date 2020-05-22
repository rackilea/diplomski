public class CustomLocalDateDeserializer extends JsonDeserializer<LocalDate> {

    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("yyMMdd")
            .parseDefaulting(ChronoField.ERA, 1)
            .toFormatter()
            .withChronology(IsoChronology.INSTANCE)
            .withResolverStyle(ResolverStyle.STRICT); // Also can be LENIENT or SMART

    @Override
    public LocalDate deserialize(JsonParser p,
                                 DeserializationContext ctxt) throws IOException {

        String value = p.getValueAsString();
        return LocalDate.parse(value, FORMATTER);
    }
}