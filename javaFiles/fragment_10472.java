public class DateUtils {

  public static Date get31OfDecember2YearsAgo() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date()); // This line is surely redundant?
    return get31OfDecember2YearsAgo(calendar);
  }

  static Date get31OfDecember2YearsAgo(Calendar calendar) {        
    int year2YearsAgo = calendar.get(Calendar.YEAR) - 2;
    calendar.set(year2YearsAgo, Calendar.DECEMBER, 31);
    return calendar.getTime();
  }
}