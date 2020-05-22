public static String readDate(String dateStr) throws ParseException {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    Date d = format.parse(dateStr);

    format = new SimpleDateFormat("MMMM dd, yyyy hh:mm:ss a");

    return format.format(d);
}