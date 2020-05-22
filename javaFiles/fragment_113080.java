public static int daysApart(long first, long second){
    GregorianCalendar gc=new GregorianCalendar(TimeZone.getTimeZone("UTC"));

    gc.setTimeInMillis(first);
    int day1=gc.get(GregorianCalendar.DAY_OF_YEAR);

    gc.setTimeInMillis(second);
    int day2=gc.get(GregorianCalendar.DAY_OF_YEAR);

    return day2-day1;
}