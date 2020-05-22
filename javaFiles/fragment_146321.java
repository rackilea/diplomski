import org.joda.time.DateMidnight;
import org.joda.time.Weeks;
import org.joda.time.Years;

public class Main {

    private String getWeek (DateMidnight dt2) {
        DateMidnight dt = new DateMidnight(2000,10,1);

        // First get the number of elapsed years, ChssPly76's way
        int yearz = Years.yearsBetween(dt, dt2).getYears();
        /*
         * We now need the number of weeks in the current year, which can be
         * calculated using the Weeks class.
         */
        int yearOffset = 1;
        // But if the new date is Oct 1 thru Dec 12 year must remain the same
        if (!dt2.isBefore (new DateMidnight(dt2.getYear(),10,1))) {
            yearOffset = 0;
        }

        int weekz = Weeks.weeksBetween(dt.withYear(dt2.getYear()-yearOffset), dt2).getWeeks();
        return(yearz + " " + weekz);
    }

    private void test (DateMidnight testDate) {
        System.out.println("For date " + testDate + " years/weeks = " + getWeek(testDate));
    }

    private void run() {
        test (new DateMidnight());
        test (new DateMidnight(2010,10,8));
        test (new DateMidnight(2010,9,30));
        test (new DateMidnight(2000,10,1));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}