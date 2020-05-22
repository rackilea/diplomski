private static SimpleDateFormat timeFormatter= new SimpleDateFormat("hh:mm:ss a");

public static String getCurrentDate() {
    Date date = new Date();
    return timeFormatter.format(date);
}