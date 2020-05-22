public static Date test(String value) throws ... {
    for (String pattern : patterns) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = df.parse(value, new ParsePosition(0));
        if (date != null) {
            return date;
        }
    }
    // Do whatever you want here - throw ParseException, or return null
}