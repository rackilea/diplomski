public Date sumDates(String[] dateStrings, DateFormat df) {
    int secs=0, mins=0, hrs=0;
    Calendar calendar = Calendar.getInstance();
    for (int i=0; i<dateStrings.length; i++) {
        String dateString = dateStrings[i];
        Date date = (Date) df.parse(dateString);
        calendar.setTime(date);
        secs += calendar.get(Calendar.SECOND);
        mins += calendar.get(Calendar.MINUTE);
        hrs += calendar.get(Calendar.HOUR);
    }
    calendar.set(0, 0, 0, hrs, mins, secs);
    return calendar.getTime();
}