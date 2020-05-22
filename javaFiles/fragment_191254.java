static final DateTimeFormatter formatter = DateTimeFormatter
        .ofPattern("h:mm a", Locale.ENGLISH)
        .withZone(ZoneId.of("Asia/Kathmandu"));

static String formatTime(Instant time) {
    return formatter.format(time);
}