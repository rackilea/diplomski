LocalDate baseDate = LocalDate.of(1899, Month.DECEMBER, 30);

    ZoneId berlin = ZoneId.of("Europe/Berlin");
    TimeZone tzb = TimeZone.getTimeZone(berlin);
    GregorianCalendar gcb = new GregorianCalendar(tzb);
    gcb.set(1899, Calendar.DECEMBER, 30);
    ZonedDateTime zdtb = baseDate.atStartOfDay(berlin);
    System.out.println("" + berlin + ' ' + tzb.getOffset(gcb.getTimeInMillis())
            + ' ' + berlin.getRules().getOffset(zdtb.toInstant())
            + ' ' + berlin.getRules().getOffset(zdtb.toInstant()).getTotalSeconds());