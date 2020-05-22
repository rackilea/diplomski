public class Time {
    public static void main(String[] args) {
        String ANNOUNCEMENT_DATE1 = "Mon, 25-Aug-2014 10:00:00 GMT";
        String ANNOUNCEMENT_DATE2 = "Mon, 25-Aug-2014 11:00:00 GMT";

        DateFormat df = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss z", Locale.ENGLISH);

        Date announcementDate1 = null;
        Date announcementDate2 = null;
        try {
            announcementDate1 = df.parse(ANNOUNCEMENT_DATE1);
            announcementDate2 = df.parse(ANNOUNCEMENT_DATE2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long now = System.currentTimeMillis();
        System.out.println(now >= announcementDate1.getTime());
        System.out.println(now >= announcementDate2.getTime());
    }
}