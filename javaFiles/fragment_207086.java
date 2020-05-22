enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    static{
        MONDAY.next = TUESDAY;
        TUESDAY.next = WEDNESDAY;
        WEDNESDAY.next = THURSDAY;
        THURSDAY.next = FRIDAY;
        FRIDAY.next = SATURDAY;
        SATURDAY.next = SUNDAY;
        SUNDAY.next = MONDAY;
    }

    private Days next;

    public Days nextDay() {
        return next;
    }

}