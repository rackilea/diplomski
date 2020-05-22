public long getTimeDiff() throws Exception {
    String arrival = "2011/Nov/10 13:15:24";
    String departure = "2011/Jan/10 13:15:24";

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");

    java.util.Date date1 = formatter.parse(arrival);
    java.util.Date date2 = formatter.parse(departure);

    return date2.getTime() - date1.getTime();
}