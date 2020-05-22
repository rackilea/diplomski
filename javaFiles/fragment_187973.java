ZoneId tz = ZoneId.of("America/Los_Angeles");
    final ZonedDateTime jobStartDateTimeZ = ZonedDateTime.of(2017, 5, 1, 10, 0, 0, 0, tz);
    Instant startTime = jobStartDateTimeZ.toInstant();
    // add summer time (DST)
    startTime = startTime.plus(tz.getRules().getDaylightSavings(startTime));
    System.out.println("Start Time " + startTime);