public enum DayOfWeekAndClosingTime implements IDayOfWeek {
    MONDAY(DayOfWeek.MONDAY, "17:30"),
    TUESDAY(DayOfWeek.TUESDAY, "17:30"),
    WEDNESDAY(DayOfWeek.WEDNESDAY, "17:30"),
    THURSDAY(DayOfWeek.THURSDAY, "17:30"),
    FRIDAY(DayOfWeek.FRIDAY, "16:00"),
    SATURDAY(DayOfWeek.SATURDAY, "Closed"),
    SUNDAY(DayOfWeek.SUNDAY, "Closed");

    private final DayOfWeek day;
    private final String closingTime;

    DayOfWeekAndClosingTime(DayOfWeek day, String closingTime) {
        this.day = day;
        this.closingTime = closingTime;
    }

    @Override
    public DayOfWeek getDayOfWeek() {
        return day;
    }

    public String getClosingTime() {
        return closingTime;
    }
}