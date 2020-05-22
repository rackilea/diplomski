enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final Days[] VALUES = Days.values(); // store result of values()
                                                        // to avoid creating new array
                                                        // each time we use values()
    public Days nextDay() {
        return VALUES[(ordinal() + 1) % 7];
    }

}