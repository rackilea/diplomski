public static final DateTimeFormatter ISO_INSTANT;
static {
    ISO_INSTANT = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendInstant()
            .toFormatter(ResolverStyle.STRICT, null);
}