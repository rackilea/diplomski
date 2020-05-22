public static String stringToDateTime(String string) {
    SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy HH:mm:ss z");
    Date date;
    String sqlDate;
    try {
        date = sdf.parse(string);
        SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sqlDate = sqlFormat.format(date);
    }
    catch(ParseException ex) {
        sqlDate = string;
    }

    return sqlDate;
}