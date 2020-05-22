SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
SimpleDateFormat Parsed_DATE_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
try {
    String timeString=new String("19860821130102");
    Log.v(TAG, "timeString=" + timeString);

    TimeZone destTimeZone = TimeZone.getDefault();
    Log.v=(TAG, "Source TimeZone: " + destTimeZone);

    DATE_TIME_FORMAT.setTimeZone(destTimeZone);
    String convertedDateString = DATE_TIME_FORMAT.format(DATE_TIME_FORMAT.parse(timeString));
    Log.v(TAG, "ConvertedDateString: " + convertedDateString);

    java.util.Date date = Parsed_DATE_TIME_FORMAT.parse(convertedDateString, new ParsePosition(0));
    Log.v(TAG, "ConvertedTime: " + date);
} catch (ParseException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}