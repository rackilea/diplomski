public class ExampleDateCalculation {

    public static void main(String[] args) {
        int dayOfMonth = 4;
        int monthOfYear = 3;
        int year = 2018;

        // create a java.time.LocalDate of the given integers
        LocalDate localDate = LocalDate.of(year, monthOfYear, dayOfMonth);

        // calculate the calendar week of it
        int calendarWeekTheLocalDateIsIn = getCalendarWeek(localDate);

        // calculate the last Monday before this date
        LocalDate lastMonday = getLastFrom(DayOfWeek.MONDAY, localDate);

        // create a formatter for your locale
        DateTimeFormatter germanDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println(localDate.format(germanDateFormatter)
                + " is in calendar week "
                + calendarWeekTheLocalDateIsIn
                + " of the system locale and the last Monday before was at "
                + lastMonday.format(germanDateFormatter));
    }

    /**
     * <p>
     * Gets the calendar week number of the given {@link LocalDate} based on the
     * {@link Locale} of the operating system.
     * </p>
     * 
     * @param localDate the date of the day
     * @return the calendar week number the day is in
     */
    public static int getCalendarWeek(LocalDate localDate) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return localDate.get(weekFields.weekOfWeekBasedYear());
    }

    /**
     * <p>
     * Gets the date of the last given weekday or day of week starting from the
     * weekday of the given date. The method calculates the date of the nearest
     * weekday chronologically backwards.
     * </p>
     * <p>
     * <strong>For example:</strong><br>
     * If the weekday of the given date is a Monday and the given day of week is a
     * Tuesday, then this method will return the date of the Tuesday before today,
     * which is 6 days back in the past.
     * </p>
     * 
     * @param weekday the day of week whose date is to be determined
     * @param from    the date to start from calculating backwards
     * @return the date of the last given day of week starting from the given date
     */
    public static LocalDate getLastFrom(DayOfWeek weekday, LocalDate from) {
        DayOfWeek fromWeekday = from.getDayOfWeek();
        int fromWeekdayValue = fromWeekday.getValue();
        int weekdaysValue = weekday.getValue();
        int daysToSubtract = 0;

        /*
         * Calculate the days to go back and be beware of negative values by means of
         * case differentiation. Get the positive difference by subtracting the smaller
         * value from the larger one and subtract a week if the result would be 0.
         */
        if (fromWeekdayValue < weekdaysValue) {
            daysToSubtract = 7 - (weekdaysValue - fromWeekdayValue);
        } else if (fromWeekdayValue > weekdaysValue) {
            daysToSubtract = fromWeekdayValue - weekdaysValue;
        } else {
            daysToSubtract = 7;
        }

        return from.minusDays(daysToSubtract);
    }
}