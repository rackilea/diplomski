public Date convertToZone(Date date, String tz) {

    DateFormat TFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    TFormat.setTimeZone(TimeZone.getTimeZone(tz));
    return df.parse(currentTFormat.format(date));
}