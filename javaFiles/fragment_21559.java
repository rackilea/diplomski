private static String randomDataOfBirth(int yearStartInclusive, int yearEndExclusive) {
    LocalDate start = LocalDate.ofYearDay(yearStartInclusive, 1);
    LocalDate end = LocalDate.ofYearDay(yearEndExclusive, 1);

    long longDays = ChronoUnit.DAYS.between(start, end);
    int days = (int) longDays;
    if (days != longDays) {
        throw new IllegalStateException("int overflow; too many years");
    }
    int day = randBetween(0, days);
    LocalDate dateOfBirth = start.plusDays(day);

    return dateOfBirth.toString();
}