static int setToValue(EnumSet<DayOfWeek> days) {
    int value = 0;
    for (DayOfWeek day : days) {
        value |= day.value();
    }
    return value;
}

static EnumSet<DayOfWeek> valueToSet(int value) {
    EnumSet<DayOfWeek> days = EnumSet.noneOf(EnumSet.class);
    for (DayOfWeek day : EnumSet.allOf(EnumSet.class)) {
        if ((value & day.value()) != 0) {
            days.add(day);
        }
    }
    return days;
}