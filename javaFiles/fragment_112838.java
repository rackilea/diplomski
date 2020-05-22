SimpleDateFormat format = new SimpleDateFormat("HH:mm");
Date now = new Date();
String time = format.format(now); // format to wall time loosing current date
System.out.println(time);
now = format.parse(time); // reparse wall time
System.out.println(now);