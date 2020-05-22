/**
 * @param s H:m timestamp, i.e. [Hour in day (0-23)]:[Minute in hour (0-59)]
 * @return total minutes after 00:00
 */
private static int toMins(String s) {
    String[] hourMin = s.split(":");
    int hour = Integer.parseInt(hourMin[0]);
    int mins = Integer.parseInt(hourMin[1]);
    int hoursInMins = hour * 60;
    return hoursInMins + mins;
}