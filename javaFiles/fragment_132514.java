Calendar cal = Calendar.getInstance();
cal.setFirstDayOfWeek(Calendar.MONDAY);
cal.setMinimalDaysInFirstWeek(4);

// Workaround
cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));

int test = cal.get(Calendar.DAY_OF_MONTH);
cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
int mon = cal.get(Calendar.DAY_OF_MONTH);
bTest.setText("" + test + "-" + mon); // Display 4-29