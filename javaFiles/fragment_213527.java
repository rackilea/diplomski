public class Test {
    public static void main(String[] arg){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ZoneId zoneId = ZoneId.of("Australia/Victoria");
        format.setTimeZone(TimeZone.getTimeZone(zoneId));
        final LocalDate localDate = LocalDate.now(zoneId).withDayOfMonth(16).withMonth(10).withYear(2017);
        final GregorianCalendar gregorianCalendar = GregorianCalendar.from(localDate.atStartOfDay(zoneId));
        System.out.println(format.format(gregorianCalendar.getTime())); //prints 2017-10-16
    }
}