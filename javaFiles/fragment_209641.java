public static Date subtractDays(int numDaysToSubstract) {
    return Date.from(Instant.now().minus(numDaysToSubstract, ChronoUnit.DAYS));
    // or
    // return Date.from(Instant.now().minus(Duration.ofDays(numDaysToSubstract)));

}