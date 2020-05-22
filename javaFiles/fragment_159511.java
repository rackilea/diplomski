int year = 2017;

// Using LocalDateTime (Java 8+ or Java 6+ with ThreeTen backport)
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
String start1 = LocalDateTime.of(year, Month.JANUARY, 1, 0, 0).format(dtf);
String stop1 = LocalDateTime.of(year, Month.DECEMBER, 31, 23, 59, 59).format(dtf);
System.out.println(start1 + " - " + stop1);

// Using Calendar (antiquated)
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Calendar cal = Calendar.getInstance();
cal.clear();
cal.set(year, Calendar.JANUARY, 1);
String start2 = sdf.format(cal.getTime());
cal.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
String stop2 = sdf.format(cal.getTime());
System.out.println(start2 + " - " + stop2);