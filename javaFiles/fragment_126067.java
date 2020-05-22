String userTimeZone = "Asia/Samarkand";
    String userDate = "2018-07-05";

    ZoneId zone = ZoneId.of(userTimeZone);
    Instant dbInstant = LocalDate.parse(userDate)
            .atStartOfDay(zone)
            .toInstant();

    System.out.println(dbInstant);