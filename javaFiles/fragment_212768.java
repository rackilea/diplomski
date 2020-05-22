public boolean hasPassedAYear(Date date) {
    long currentDate = Calendar.getInstance().getTimeInMillis();
    long dateToEval = date.getTime();
    // 1000 => milliseconds to seconds
    // 60 => seconds to minutes
    // 60 => minutes to hours
    // 24 => hours to days
    long days = (currentDate - dateToEval) / (1000 * 60  * 60 * 24);
    return days >= 365;
}