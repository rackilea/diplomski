String ts = "2016-09-12T13:15:17.309Z";
ZonedDateTime parse = 
    ZonedDateTime.parse(ts, DateTimeFormatter.ISO_DATE_TIME)
        .withZoneSameInstant(ZoneId.systemDefault());
System.out.println(parse);
System.out.println(parse.toLocalDateTime());