public static OffsetDateTime parse(String text) {
    // Fix 1-digit offset hour
    String s = text.replaceFirst("( [+-])(\\d:\\d\\d)$", "$10$2");

    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("uuuu-MM-dd xxx")
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .toFormatter();
    return OffsetDateTime.parse(s, formatter);
}