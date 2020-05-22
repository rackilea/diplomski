public void calculate(Instant now, Instant then, DateTimeZone zone) {
    LocalDate today = new LocalDate(now, zone);
    LocalDate otherDay = new LocalDate(then, zone);
    if (otherDay.equals(today)) {
        // Today day
    } else if (otherDay.equals(today.minusDays(1)) {
        // Yesterday
    } else {
        // Neither today nor yesterday
    }
}