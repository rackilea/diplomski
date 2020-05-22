public void workingDayOfYear() {
    LocalDate date = LocalDate.of(2019, 6, 24); // Java 8 date
    int initialWeekOfyear = date.get(WeekFields.of(Locale.UK).weekOfWeekBasedYear());
    int weekOfYear = initialWeekOfyear;
    do {
        LocalDate firstDayOfWeek = date.with(WeekFields.of(Locale.UK).dayOfWeek(), 1L);
        LocalDate lastWorkingDayOfWeek = date.with(WeekFields.of(Locale.UK).dayOfWeek(), 5L);

        StringBuilder result = new StringBuilder("Week : ");
        result.append(weekOfYear);
        result.append(", start=");
        result.append(firstDayOfWeek);
        result.append(", end=");
        result.append(lastWorkingDayOfWeek);

        System.out.println(result.toString());
        date = date.plusWeeks(1);
    } while ((weekOfYear = date.get(WeekFields.of(Locale.UK).weekOfWeekBasedYear())) != initialWeekOfyear);
}