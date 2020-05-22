DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    // date/time
    .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    // offset (hh:mm - "+00:00" when it's zero)
    .optionalStart().appendOffset("+HH:MM", "+00:00").optionalEnd()
    // offset (hhmm - "+0000" when it's zero)
    .optionalStart().appendOffset("+HHMM", "+0000").optionalEnd()
    // offset (hh - "Z" when it's zero)
    .optionalStart().appendOffset("+HH", "Z").optionalEnd()
    // create formatter
    .toFormatter();
System.out.println(OffsetDateTime.parse("2022-03-17T23:00:00.000+0000", formatter));
System.out.println(OffsetDateTime.parse("2022-03-17T23:00:00.000+00", formatter));
System.out.println(OffsetDateTime.parse("2022-03-17T23:00:00.000+00:00", formatter));
System.out.println(OffsetDateTime.parse("2022-03-17T23:00:00.000Z", formatter));