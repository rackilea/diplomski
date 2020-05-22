DateTimeFormatter jsonDateFormatter
            = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSSSSS");
    DateTimeFormatter turkishDateFormatter
            = DateTimeFormatter.ofPattern("EEEE MMM d", Locale.forLanguageTag("tr"));
    ZoneId zone = ZoneId.of("Europe/Istanbul");

    String dateFromJson = "2019-11-27 14:42:23.000000";
    String timezoneTypeFromJson = "3";
    String timezoneFromJson = "UTC";

    if (! timezoneTypeFromJson.equals("3")) {
        throw new IllegalStateException("This Stack Overflow answer only supports timezone_type 3");
    }
    LocalDateTime ldt = LocalDateTime.parse(dateFromJson, jsonDateFormatter);
    ZoneId jsonZone = ZoneId.of(timezoneFromJson);
    ZonedDateTime dateTime = ldt.atZone(jsonZone).withZoneSameInstant(zone);
    ZonedDateTime futureDateTime = dateTime.plusMonths(4);
    String wantedDateString = futureDateTime.format(turkishDateFormatter);

    System.out.println(wantedDateString);