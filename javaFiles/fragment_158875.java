private static DateTimeFormatter formatter
        = DateTimeFormatter.ofPattern("EEE dd MMM yyyy HH:mm:ss z", Locale.UK);
private static ZoneId britain = ZoneId.of("Europe/London");
private static ZoneId gmt = ZoneId.of("Etc/GMT");

private static String toGMT(final Date date) {
    ZonedDateTime britishTime = date.toInstant().atZone(britain);
    ZonedDateTime gmtTime = britishTime.withZoneSameLocal(gmt);
    return gmtTime.format(formatter);
}