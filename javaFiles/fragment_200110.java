Calendar c1 = new GregorianCalendar(TimeZone.getTimeZone("GMT-4"));
int hour = c1.get(Calendar.HOUR);         
int minutes = c1.get(Calendar.MINUTE);     
int seconds = c1.get(Calendar.SECOND);

tv2.setText(String.format("%d:%d:%d", hour, minutes, seconds));