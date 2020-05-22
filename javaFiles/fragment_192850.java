Set<ZoneId> preferedZones = new HashSet<>();
preferedZones.add(ZoneId.of("America/Chicago"));
DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    // append first part of pattern (before timezone)
    .appendPattern("yyyy-MM-dd'T'HH:mm:ss[.S]'T'")
    // append zone name, use prefered zones (optional)
    .optionalStart().appendZoneText(TextStyle.SHORT, preferedZones).optionalEnd()
    // offset (optional)
    .appendPattern("[xxx]")
    // create formatter
    .toFormatter();