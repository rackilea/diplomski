public class CalendarTest {
    public static void main(String[] args) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal2.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);

        List<Calendar> calendars = Arrays.asList(cal1, cal2);
    }
}