public void calculateDifference(Date startDate, Date endDate) {
    long different = endDate.getTime() - startDate.getTime();

    long secondsInMilli = 1000;
    long minutesInMilli = secondsInMilli * 60;
    long hoursInMilli = minutesInMilli * 60;
    long daysInMilli = hoursInMilli * 24;

    long days = different / daysInMilli;
    different = different % daysInMilli;

    long hours = different / hoursInMilli;
    different = different % hoursInMilli;

    long minutes = different / minutesInMilli;
    different = different % minutesInMilli;

    long seconds = different / secondsInMilli;

    Log.e("calculation", "Days: " + days + " Hours: " + hours + " Minutes: " + minutes + " Seconds: " + seconds);

}