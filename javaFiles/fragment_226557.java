private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
        "d MMM yyyy HH:mm:ss.SSS");

public String calculateDuration(String startDateStr, String endDateStr)
        throws ParseException {

    String methodName = "calculateDuration";
    Date startDate = DATE_FORMAT.parse(startDateStr);
    Date endDate = DATE_FORMAT.parse(endDateStr);

    // in milliseconds
    long diff = endDate.getTime() - startDate.getTime();

    long diffMiliseconds = diff % 1000;
    long diffSeconds = diff / 1000 % 60;
    long diffMinutes = diff / (60 * 1000) % 60;
    long diffHours = diff / (60 * 60 * 1000) % 24;

    return String.format("%02d:%02d:%02d.%02d", diffHours, diffMinutes,
            diffSeconds, diffMiliseconds);
}