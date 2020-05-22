ZoneId zone = ZoneId.of("America/Los_Angeles");
    DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ROOT);

    String date1 = "Wed Oct 23 11:30:00 GMT 2019";
    String date2 = "Mon Nov 04 12:30:00 GMT 2019";

    ZonedDateTime startDateTime = ZonedDateTime.parse(date1, formatter)
            .withZoneSameInstant(zone);
    ZonedDateTime endDateTime = ZonedDateTime.parse(date2, formatter)
            .withZoneSameInstant(zone);
    while (! startDateTime.isAfter(endDateTime)) {
        Instant gmt = startDateTime.toInstant();
        System.out.println(startDateTime + "  GMT: " + gmt);
        startDateTime = startDateTime.plusDays(1);
    }