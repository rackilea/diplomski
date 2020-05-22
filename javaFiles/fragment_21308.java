public static enum StringToInstantConverter implements Converter<String, Instant> {
    INSTANCE;
    @Override
    public Instant convert(String source) {
        try {
            return Instant.parse(source);
        } catch(DateTimeParseException ex) {
        }
        return null;
    }
}