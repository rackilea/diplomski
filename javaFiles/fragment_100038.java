static DateTimeFormatter timeFormatter = new DateTimeFormatterBuilder()
        .appendPattern("HHmmss")
        .appendFraction(ChronoField.NANO_OF_SECOND, 3, 4, true)
        .toFormatter(Locale.ROOT);
static ZoneId zone = ZoneId.of("Europe/Paris");

public static ZonedDateTime utcToLocalTimeFromLock(String timestamp) {
    return LocalDate.now(ZoneOffset.UTC)
            .atTime(LocalTime.parse(timestamp, timeFormatter))
            .atOffset(ZoneOffset.UTC)
            .atZoneSameInstant(zone);
}