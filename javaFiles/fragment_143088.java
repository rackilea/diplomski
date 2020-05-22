public static boolean isWeekend(Date date) {
  Calendar cal = Calendar.getInstance();
  cal.setTime(date);
  int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
  return dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY;
}