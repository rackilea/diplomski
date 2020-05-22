private static void convertTimeZone(String date, String time,
            TimeZone fromTimezone, TimeZone toTimeZone) throws ParseException {
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    df.setTimeZone(fromTimezone);
    Date d = df.parse(date + " " + time);
    df.setTimeZone(toTimeZone);
    System.out.println("Time in " + toTimeZone.getDisplayName() + " : " +
                       df.format(d));
}