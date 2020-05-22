Calendar cal = Calendar.getInstance();
int year  = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);
int day   = cal.get(Calendar.DAY_OF_MONTH);
cal.clear();
cal.set(year, month, day);
java.sql.Date today = new java.sql.Date(cal.getTimeInMillis());