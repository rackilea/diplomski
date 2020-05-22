ZoneId warsaw = ZoneId.of("Europe/Warsaw");
    TimeZone tzw = TimeZone.getTimeZone(warsaw);
    GregorianCalendar gcw = new GregorianCalendar(tzw);
    gcw.set(1899, Calendar.DECEMBER, 30);
    ZonedDateTime zdtw = baseDate.atStartOfDay(warsaw);
    System.out.println("" + warsaw + ' ' + tzw.getOffset(gcw.getTimeInMillis())
            + ' ' + warsaw.getRules().getOffset(zdtw.toInstant())
            + ' ' + warsaw.getRules().getOffset(zdtw.toInstant()).getTotalSeconds());