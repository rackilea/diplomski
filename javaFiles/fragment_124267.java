private static DateTimeFormatter formatter 
        = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSS[XXX]")
                .withZone(ZoneOffset.UTC);

public static Instant parse(String offsetDateTimeString) {
    return OffsetDateTime.parse(offsetDateTimeString, formatter).toInstant();
}