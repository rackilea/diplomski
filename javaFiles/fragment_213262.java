public Date convertStringToDate(String dateString) throws ParseException {
    Date result;
    synchronized(df) {
        result = df.parse(dateString);
    }
    return result;
}