public void handleDayOfWeek(IDayOfWeek day) {
    DayOfWeek dayOfWeek = day.getDayOfWeek();
    // do something
    if (day instanceof DayOfWeekAndClosingTime)
        handleClosingTime((DayOfWeekAndClosingTime) day);
}