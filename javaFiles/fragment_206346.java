public static Date localToGMT() {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    Date gmt = new Date(sdf.format(date));
    return gmt;
}