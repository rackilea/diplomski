Calendar mycalendar = Calendar.getInstance();
mycalendar.set(Calendar.HOUR_OF_DAY, 1);
mycalendar.set(Calendar.MINUTE, 30);
mycalendar.set(Calendar.SECOND, 0);

// format: hour:minute:second
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
String hms = sdf.format(mycalendar.getTime()); // 01:30:00