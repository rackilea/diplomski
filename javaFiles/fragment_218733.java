DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd").withZone(DateTimeZone.UTC);
DateTime d1 = formatter.parseDateTime("2015-09-23");
DateTime d2 = formatter.parseDateTime("2024-05-07");
DateTime d3 = formatter.parseDateTime("2024-03-13");

// comparing timestamp millis between DateTime and java.util.Date
System.out.println(d1.getMillis() == d1.toDate().getTime());
System.out.println(d2.getMillis() == d2.toDate().getTime());
System.out.println(d3.getMillis() == d3.toDate().getTime());