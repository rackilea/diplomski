Calendar cal = Calendar.getInstance();
cal.setFirstDayOfWeek(Calendar.MONDAY);
cal.setMinimalDaysInFirstWeek(4);
cal.set(2011, 8, 4);
int test = cal.get(Calendar.DAY_OF_MONTH);
cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
int mon = cal.get(Calendar.DAY_OF_MONTH);
bTest.setText("" + test + "-" + mon);