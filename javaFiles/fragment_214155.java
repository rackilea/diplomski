GregorianCalendar gcal = new GregorianCalendar(TimeZone.getDefault());
java.util.Date serverDate = new Date(); // here for demonstration, use that from server
gcal.setTime(serverDate);
int year = gcal.get(Calendar.YEAR);
int month = gcal.get(Calendar.MONTH) + 1;
int dayOfMonth = gcal.get(Calendar.DAY_OF_MONTH);