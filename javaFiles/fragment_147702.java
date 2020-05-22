public ZonedDateTime from(Timestamp timestamp) {
    if (timestamp == null) {
        return null;
    }
    final ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(timestamp.toInstant(), ZoneId.of("UTC"));
    return zonedDateTime;
}

public Timestamp to(ZonedDateTime zonedDateTime) {
    if (zonedDateTime == null) {
        return null;
    }
    final Timestamp timestamp = Timestamp.valueOf(zonedDateTime.withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime());
    return timestamp;
}