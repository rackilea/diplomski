public class DateFormater {
    private static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss +05:30";
    private static String TAG = DateFormater.class.getSimpleName();

    public static Date getDate(String s) {
        // Input s = 2016-08-05 14:46:53 +05:30
        Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
            date = dateFormat.parse(s);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getCurrentDateString(Date date) {
        DateFormat dateFormat = SimpleDateFormat
                .getDateInstance(DateFormat.MEDIUM);
        return dateFormat.format(date);
    }

    public static String getCurrentTimeString(Date date) {
        DateFormat dateFormat = SimpleDateFormat
                .getTimeInstance(DateFormat.SHORT);
        return dateFormat.format(date);// Tue Jan 05 14:46:53 GMT+05:30 2016
    }       
}