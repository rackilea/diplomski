public class TestDueDate {

    public static final int WEEKS_IN_PREGNANCY = 40;
    public static final int DAYS_IN_PREGNANCY = WEEKS_IN_PREGNANCY * 7;

    public static void main(String[] args) {

        DateTime dueDate = new DateTime();
        dueDate = dueDate.plusDays(DAYS_IN_PREGNANCY);

        System.out.println("dueDate = " + dueDate);

        DateTime today = DateTime.now();

        Days d = Days.daysBetween(today, dueDate);

        int daysRemaining = d.getDays();

        int daysIn = DAYS_IN_PREGNANCY - daysRemaining;

        int weekValue = daysIn / 7;
        int weekPart = daysIn % 7;

        String week = weekValue + "." + weekPart;

        System.out.println("Days remaining = " + daysRemaining);
        System.out.println("Days In = " + daysIn);
        System.out.println("Week = " + week);

    }
}