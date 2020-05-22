public enum WeekDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}