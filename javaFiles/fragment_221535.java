/**
 *  Android utility to get the elapsed milliseconds between a String timestamp (in the future) and the current time
 * @param timeStamp Accepts a String in the form of HH:mm:ss
 * @return Elapsed time in milliseconds
 * @throws ParseException
 */
public static long timeDiff(String timeStamp) throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    Date arrivalTime = formatter.parse(timeStamp);

    Calendar arrivalCal= Calendar.getInstance();
    arrivalCal.set(Calendar.HOUR_OF_DAY, arrivalTime.getHours());
    arrivalCal.set(Calendar.MINUTE, arrivalTime.getMinutes());
    arrivalCal.set(Calendar.SECOND, arrivalTime.getSeconds());
    arrivalCal.set(Calendar.MILLISECOND, 0);

    return arrivalCal.getTimeInMillis() - System.currentTimeMillis();
}