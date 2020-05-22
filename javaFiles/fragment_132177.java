public static List<Schedule> getSchedule(List<Schedule> schedules, DateRange dateRange) {
    for (Schedule scheduleTime : schedules) {
        if(dateRange.isDate()) {
            // Do something based on the Date constructor.
        } else if(dateRange.isString()) {
            // Do something based on the String constructor.
        } else if(dateRange.isInt()) {
            // Do something based on the int constructor.
        }
    }
    return schedules;
}