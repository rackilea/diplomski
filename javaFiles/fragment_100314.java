public static java.time.OffsetDateTime convertFrom(org.threeten.bp.OffsetDateTime ttOdt) {
    // convert the instance part by part...
    return java.time.OffsetDateTime.of(ttOdt.getYear(), ttOdt.getMonthValue(),
            ttOdt.getDayOfMonth(), ttOdt.getHour(), ttOdt.getMinute(),
            ttOdt.getSecond(), ttOdt.getNano(),
            // ZoneOffset isn't compatible, we need to extract the String-ID
            java.time.ZoneOffset.of(ttOdt.getOffset().toString()));
}