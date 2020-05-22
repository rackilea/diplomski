import java.util.Calendar;
import java.util.Date;

public class Example {
  public static void main(String[] args) {
    System.out.println(getMinCalendarDate());
  }

  public static Date getMinCalendarDate() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.MONTH, -7);
    // set the day of month to the 25th
    cal.set(Calendar.DAY_OF_MONTH, 25);
    return cal.getTime();
  }
}