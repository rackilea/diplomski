ZoneId zone = ZoneId.of("Europe/London");
    long epochMillis = 1_540_700_000_000L;
    LocalDate date = Instant.ofEpochMilli(epochMillis)
            .atZone(zone)
            .toLocalDate();
    int hoursInDay = (int) ChronoUnit.HOURS.between(
            date.atStartOfDay(zone),
            date.plusDays(1).atStartOfDay(zone));
    System.out.println(date + " is " + hoursInDay + " hours");