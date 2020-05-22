Calendar cal = Calendar.getInstance();
int currentYear = cal.get(Calendar.YEAR);
cal.setTime(dateObj);
//set the year to current year
cal.set(Calendar.YEAR, currentYear);
//new date object with current year
dateObj = cal.getTime();