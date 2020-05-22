DateTimeFormatter desiredFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
    String date = "2018-12-08T07:50:00+01:00";
    OffsetDateTime dateTime = OffsetDateTime.parse(date);
    OffsetDateTime dateTimeInUtc = dateTime.withOffsetSameInstant(ZoneOffset.UTC);
    date = dateTimeInUtc.format(desiredFormatter);
    System.out.println(date);