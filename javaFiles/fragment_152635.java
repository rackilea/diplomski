// create time for 01:30
LocalTime time = LocalTime.of(1, 30);
// format: hour:minute:second
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
String hms = fmt.format(time);
System.out.println(hms); // 01:30:00