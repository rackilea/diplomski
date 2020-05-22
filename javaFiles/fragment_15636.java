class Global {

    static String strDate = format(new Date(), "dd/MM/yyyy", "GIVEN_TIMEZONE");

    private static String format(Date date, String format, String timeZoneID) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        df.setTimeZone(TimeZone.getTimeZone(timeZoneID));
        return df.format(date);
    }

}