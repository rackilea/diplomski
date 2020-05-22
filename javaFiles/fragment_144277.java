ZoneId zone = ZoneId.of("Asia/Ashkhabad");
    Map<Unit, ChronoUnit> units = Map.of(Unit.days, ChronoUnit.DAYS,
            Unit.months, ChronoUnit.MONTHS, Unit.years, ChronoUnit.YEARS);

    Time timeToSubtract = new Time(15, Unit.months);

    Instant result = ZonedDateTime.now(zone)
            .minus(timeToSubtract.getNumber(), units.get(timeToSubtract.getUnit()))
            .toInstant();
    System.out.println("15 months ago was " + result);