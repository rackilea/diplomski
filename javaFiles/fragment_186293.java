DateTimeFormatter origFormatter 
            = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSSSSS XXXXX");
    DateTimeFormatter desiredFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
    ZoneId desiredZone = ZoneId.of("America/Fort_Nelson");

    String feUltMod = "2018-07-20 18:53:46.598000 +02:00:00";
    OffsetDateTime dateTime = OffsetDateTime.parse(feUltMod, origFormatter);
    ZonedDateTime dateTimeWithTimeZoneApplied = dateTime.atZoneSameInstant(desiredZone);
    feUltMod = dateTimeWithTimeZoneApplied.format(desiredFormatter);
    System.out.println(feUltMod);