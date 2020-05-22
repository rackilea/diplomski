public class DaysOfWeek {
    private final Map daysOfWeek = new HashMap();
    public DaysOfWeek() { 
      // prepopulate my map
      daysOfWeek.put(0, "Sunday");
      daysOfWeek.put(1, "Monday");
      // etc
    }

    public String getDayName(int dayOfWeek) {
      return daysOfWeek(dayOfWeek);
    }
}