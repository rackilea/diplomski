private static String convertHHMMtoGMT(String HHMM)
{       
    Calendar day = Calendar.getInstance();
    day.set(Calendar.HOUR_OF_DAY, hour);
    day.set(Calendar.MINUTE, min);
    day.set(Calendar.SECOND, 00);
    day.set(Calendar.MILLISECOND, 00);    

    SimpleDateFormat gmtFormat = new SimpleDateFormat("yyyyMMdd-HH:mm:ss");
    gmtFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

    return gmtFormat.format(day.getTime());
}