import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormatDateCalendar {
   public static final String FORMAT_STRING = "%1$-3td %1$-9tB %1$tY";
   public static void main(String[] args) {
      Calendar c1 = new GregorianCalendar(2011, Calendar.FEBRUARY, 3);
      Calendar c2 = new GregorianCalendar(2010, Calendar.MAY, 15);
      Date today = new Date();

      System.out.printf(FORMAT_STRING + "%n", c1);
      System.out.printf(FORMAT_STRING + "%n", c2);
      System.out.printf(FORMAT_STRING + "%n", today);
   }
}