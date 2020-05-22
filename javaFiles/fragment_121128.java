Calendar cal = Calendar.getInstance();
int year  = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);
int date  = cal.get(Calendar.DATE);
cal.clear();
cal.set(year, month, date);
long todayMillis2 = cal.getTimeInMillis();