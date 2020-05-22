ZoneId here = ZoneId.of("America/Danmarkshavn");
    ZonedDateTime now = ZonedDateTime.now(here);
    ZonedDateTime nextMondayAtThree = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY))
            .with(LocalTime.of(3, 0));
    long secondsUntilMonday = ChronoUnit.SECONDS.between(now, nextMondayAtThree);
    System.out.println(nextMondayAtThree);
    System.out.println("Seconds: " + secondsUntilMonday);