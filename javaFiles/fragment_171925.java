// Time from a ClockPicker is "hh:mm"
private Date getTime(String time) {

    if (time != null)
        return makeCalendar(getTimeComponents(getTimeComponents(time))).getTime();
    return null;
}

private String[] getTimeComponents(String time) {
    return time.split(":");
}

private int[] getTimeComponents(String... time) {
    int hour = Integer.parseInt(time[0]);
    return new int[] { 
            hour, 
            Integer.parseInt(time[1]), 
            0, 
            hour >= PM ? Calendar.AM : Calendar.PM 
    };
}