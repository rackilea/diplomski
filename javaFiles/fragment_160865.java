public static Date getUTCToDate(String utc){
    // String exampleOfUTCTime = "2016-09-27T19:35:32.717";

    try{
        Log.d("asd-timeBefore", "getUTCToDate: " + utc);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date d = formatter.parse(utc);
        Log.d("asd-timeAfter", "getUTCToDate: " + d);
        return d;
    } catch (ParseException e){
        e.printStackTrace();
    }
    return null;
}