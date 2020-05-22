public static Calendar getDayStart(final long timeInMillis) {
    final Calendar cal = Calendar.getInstance();
    // end time as a date
    cal.setTimeInMillis(timeInMillis);

    cal.set(Calendar.HOUR, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);

    return cal;
}

public static List<String> getDatesRange(final long start, final long end) {

    final Calendar cal = getDayStart(start);
    final Date startDate = cal.getTime();

    final Calendar calEnd = getDayStart(end);
    //adding one day because of the strict comparison in the while below
    calEnd.add(Calendar.DAY_OF_YEAR, 1);
    final Date endDate = calEnd.getTime();

    final SimpleDateFormat formatter = new SimpleDateFormat("MMM d, yyyy HH:mm:ss");

    final List<String> dates = new ArrayList<String>();
    final Date dayEnd;
    String currentDay = "";

    while(cal.getTime().before(endDate)) {
        currentDay = formatter.format(cal.getTime());
        currentDay += " - ";
        //going to the end of the day
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.add(Calendar.SECOND, -1);
        currentDay += formatter.format(cal.getTime());
        //going to next day again and continue the loop
        cal.add(Calendar.SECOND, 1);
        //add what we computed to the list of days
        dates.add(currentDay);
    }

    return dates;
}