Calendar todayPlus30 = new GregorianCalendar() {{
  add(Calendar.DAY_OF_YEAR, 30);
  set(Calendar.HOUR_OF_DAY, 0);
  set(Calendar.MINUTE, 0);
  set(Calendar.SECOND, 0);
  set(Calendar.MILLISECOND, 0);
}};