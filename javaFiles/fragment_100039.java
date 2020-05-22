public static Date utcToLocalTimeFromLock(String timestamp) {
    Instant inst= LocalDate.now(ZoneOffset.UTC)
            .atTime(LocalTime.parse(timestamp, timeFormatter))
            .atOffset(ZoneOffset.UTC)
            .toInstant();
    return Date.from(inst);
}