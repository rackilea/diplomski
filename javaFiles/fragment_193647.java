public enum DayOfWeek {
    MONDAY(Calendar.MONDAY), 
    ...;

    private final int dayOfWeek;

    DayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int intValue() {
        return dayOfWeek;
    }
}