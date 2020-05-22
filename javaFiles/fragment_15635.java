class Global {

    static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    static {
        df.setTimeZone(TimeZone.getTimeZone("GIVEN_TIMEZONE"));
    }
    static String strDate = df.format(new Date());

}