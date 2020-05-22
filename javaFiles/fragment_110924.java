public static class WeeklyDateAxis extends DateAxis {

  private static final long serialVersionUID = 1L;
  private Locale locale;

  public WeeklyDateAxis(String label, TimeZone zone, Locale locale) {
    super(label, zone, locale);
    this.locale = locale;
  }

  @Override
  protected Date previousStandardDate(Date date, DateTickUnit unit) {
    Calendar cal = Calendar.getInstance(getTimeZone(), locale);
    cal.setTime(date);
    resetFieldBelowDay(cal);

    cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
    return cal.getTime();
  }

  @Override
  protected Date nextStandardDate(Date date, DateTickUnit unit) {
    Date previous = previousStandardDate(date, unit);
    Calendar cal = Calendar.getInstance(getTimeZone(), locale);
    cal.setTime(previous);
    resetFieldBelowDay(cal);

    cal.add(Calendar.WEEK_OF_YEAR, 1);
    return cal.getTime();
  }

  private void resetFieldBelowDay(Calendar cal) {
    cal.clear(Calendar.MILLISECOND);
    cal.clear(Calendar.SECOND);
    cal.clear(Calendar.MINUTE);
    cal.set(Calendar.HOUR_OF_DAY, 0);
  }
}