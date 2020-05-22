public abstract class CategoryBase {
  public abstract long getDate();  // long or whatever

  public Calendar getCalendar() {
    Calendar calendar = new Calendar();
    calendar.setTime(getDate());
    return calendar;
  }
}