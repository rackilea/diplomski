// start 1 year 6 months before today
    // please change to the number of years, months, weeks and/or days you require
    ZonedDateTime start = ZonedDateTime.now(ZoneId.systemDefault()).minusYears(1).minusMonths(6);
    // end 1 month after today - also change to your own requirements
    ZonedDateTime end = ZonedDateTime.now(ZoneId.systemDefault()).plusMonths(1);

    List<Calendar> satsAndSuns = new ArrayList<>(200);
    ZonedDateTime current = start;
    if (current.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
        satsAndSuns.add(GregorianCalendar.from(current));
    }
    current = current.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
    while (! current.isAfter(end)) {
        satsAndSuns.add(GregorianCalendar.from(current));
        // add 1 day to get Sunday
        current = current.plusDays(1);
        assert current.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        if (current.isAfter(end)) {
            break;
        }
        satsAndSuns.add(GregorianCalendar.from(current));
        // add 6 days to get Saturday
        current = current.plusDays(6);
        assert current.getDayOfWeek().equals(DayOfWeek.SATURDAY);
    }
    Calendar[] selecatbleDays = satsAndSuns.toArray(new Calendar[satsAndSuns.size()]);