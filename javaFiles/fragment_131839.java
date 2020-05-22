int mins = 180;
Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, mins/60);
cal.set(Calendar.MINUTE, mins % 60);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
String hhmm = sdf.format(cal.getTime());
System.out.println(hhmm);