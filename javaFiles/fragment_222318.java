public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat format = new SimpleDateFormat("H:mm a Z");
    List<TimeZone> zones = Arrays.asList(
            TimeZone.getTimeZone("CST"),
            TimeZone.getTimeZone("UTC"),
            TimeZone.getTimeZone("Asia/Shanghai"),
            TimeZone.getTimeZone("Japan"));
    for (TimeZone zone : zones) {
        calendar.setTimeZone(zone);
        format.setTimeZone(zone);
        System.out.println(
                calendar.get(Calendar.HOUR_OF_DAY) + ":"
                + calendar.get(Calendar.MINUTE) + " "
                + (calendar.get(Calendar.AM_PM) == 0 ? "AM " : "PM ")
                + (calendar.get(Calendar.ZONE_OFFSET) / 1000 / 60 / 60));
        System.out.println(format.format(calendar.getTime()));
    }
}