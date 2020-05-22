DateTimeFormatter parser2 = ISODateTimeFormat.dateTimeNoMillis();
    DateTime dt = new DateTime();
    DateTime dt2 = new DateTime();
    dt = DateTime.parse("2012-11-05T13:00:00+0200");
    System.out.println(dt.toString());

    dt2 = DateTime.parse("2012-11-05T21:45:00-08:00");
    DateTimeZone dtz = dt2.getZone();
    System.out.println(dt.withZone(dtz).toString());