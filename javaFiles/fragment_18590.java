public static void main(String[] args) {
    final LocalDate start = LocalDate.now();
    final LocalDate end = new LocalDate(2012, 1, 14);

    LocalDate weekday = start;

    if (start.getDayOfWeek() == DateTimeConstants.SATURDAY ||
            start.getDayOfWeek() == DateTimeConstants.SUNDAY) {
        weekday = weekday.plusWeeks(1).withDayOfWeek(DateTimeConstants.MONDAY);
    }

    while (weekday.isBefore(end)) {
        System.out.println(weekday);

        if (weekday.getDayOfWeek() == DateTimeConstants.FRIDAY)
            weekday = weekday.plusDays(3);
        else
            weekday = weekday.plusDays(1);
    }
}