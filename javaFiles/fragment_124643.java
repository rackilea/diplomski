// set of preferred zones
Set<ZoneId> preferredZones = new HashSet<ZoneId>();
// my arbitrary choice for CET
preferredZones.add(ZoneId.of("Europe/Berlin"));
DateTimeFormatter dtf = new DateTimeFormatterBuilder()
    // date/time
    .appendPattern("dd.MM.yyyy HH:mm ")
    // zone names
    .appendZoneText(TextStyle.SHORT, preferredZones)
    // create formatter
    .toFormatter(Locale.US);

ZonedDateTime zdt = ZonedDateTime.parse("06.03.2018 06:00 CET", dtf);