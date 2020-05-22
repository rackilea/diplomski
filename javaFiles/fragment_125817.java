public class WeekdayInMonth {

    private final boolean backwards;

    private final DayOfWeek dayOfWeek;

    private final int position;

    private WeekdayInMonth(DayOfWeek dayOfWeek, int position, boolean backwards) {
        if (position < 1 || position > 5) {
            throw new DateTimeException("Position in month must be between 1 and 5 inclusive");
        }
        this.dayOfWeek = dayOfWeek;
        this.position = position;
        this.backwards = backwards;
    }
}