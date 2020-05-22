public static OffsetDateTime toUTC(LocalDateTime ldt) {
    return fromZoneToUtc(ldt, ZoneId.systemDefault());
}

static OffsetDateTime fromZoneToUtc(LocalDateTime ldt, ZoneId timeZone) {
    return ldt.atZone(timeZone).toOffsetDateTime().withOffsetSameInstant(ZoneOffset.UTC);
}