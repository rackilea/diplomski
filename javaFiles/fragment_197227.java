DayOfWeekAndClosingTime(DayOfWeek day) {
    this.day = day;
    String time = "unknown";
    switch(day) {
        case MONDAY:
        case TUESDAY:
        case WEDNESDAY:
        case THURSDAY:
            time = "17:30";
            break;
        case FRIDAY:
            time = "16:00";
            break;
        case SATURDAY:
        case SUNDAY:
            time = "closed";
            break;
    }
    this.closingTime = time;
}