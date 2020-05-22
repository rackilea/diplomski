Calendar calendar = Calendar.getInstance();
Calendar LATime = new GregorianCalendar(TimeZone.getTimeZone("America/Los_Angeles"));
LATime.setTimeInMillis(calendar.getTimeInMillis());
int year = LATime.get(Calendar.YEAR);
int month = LATime.get(Calendar.MONTH);
int date = LATime.get(Calendar.DATE);