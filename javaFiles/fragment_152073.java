private static void listSecondsPerDayBetween(DateTime from, DateTime to) {
    System.out.println(from.toString("yyyy-MM-dd HH:mm:ss") + " - " + to.toString("yyyy-MM-dd HH:mm:ss"));
    if (! from.isBefore(to))
        throw new IllegalArgumentException("Values are inverted: " + from + ", " + to);
    LocalDate date = from.toLocalDate().plusDays(1);
    DateTime nextMidnight = date.toDateTimeAtStartOfDay();
    DateTime prev = from;
    while (nextMidnight.isBefore(to)) {
        Seconds seconds = Seconds.secondsBetween(prev, nextMidnight);
        System.out.println("  " + prev.toString("yyyy-MM-dd") + "  " + seconds.getSeconds() + " seconds");
        prev = nextMidnight;
        date = date.plusDays(1);
        nextMidnight = date.toDateTimeAtStartOfDay();
    }
    Seconds seconds = Seconds.secondsBetween(prev, to);
    System.out.println("  " + prev.toString("yyyy-MM-dd") + "  " + seconds.getSeconds() + " seconds");
}