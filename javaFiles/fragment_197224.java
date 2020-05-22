public enum DayOfWeek implements IDayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public DayOfWeek getDayOfWeek() {
        return this;
    }
}