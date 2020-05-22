public final class DayOfWeekTimeRange {
    private final DayOfWeek fromDay;
    private final LocalTime fromTime;
    private final DayOfWeek toDay;
    private final LocalTime toTime;
    private final boolean   inverted;
    public DayOfWeekTimeRange(DayOfWeek fromDay, LocalTime fromTime, DayOfWeek toDay, LocalTime toTime) {
        this.fromDay = fromDay;
        this.fromTime = fromTime;
        this.toDay = toDay;
        this.toTime = toTime;
        this.inverted = compare(this.fromDay, this.fromTime, this.toDay, this.toTime) > 0;
    }
    public boolean inRange(LocalDateTime dateTime) {
        return inRange(dateTime.getDayOfWeek(), dateTime.toLocalTime());
    }
    public boolean inRange(DayOfWeek day, LocalTime time) {
        boolean fromOk = compare(day, time, this.fromDay, this.fromTime) >= 0; // Lower-inclusive
        boolean toOk   = compare(day, time, this.toDay  , this.toTime  ) <  0; // Upper-exclusive
        return (this.inverted ? fromOk || toOk : fromOk && toOk);
    }
    private static int compare(DayOfWeek day1, LocalTime time1, DayOfWeek day2, LocalTime time2) {
        int cmp = day1.compareTo(day2);
        if (cmp == 0)
            cmp = time1.compareTo(time2);
        return cmp;
    }
}