private static boolean is12HoursOrLonger(LocalTime begin, LocalTime end) {
    Duration length = Duration.between(begin, end);
    if (length.isNegative()) {
        length = length.plusDays(1);
    }
    return ! length.minusHours(12).isNegative();
}

private static LocalTime toAm(LocalTime time) {
    return time.with(ChronoField.AMPM_OF_DAY, 0);
}