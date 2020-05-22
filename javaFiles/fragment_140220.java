String s = "2014-01-15T14:23:50.026PST";
DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSz");

DateTime instant = dtf.parseDateTime(s);
System.out.println(dtf.print(instant)); // abort

Exception in thread "main" java.lang.IllegalArgumentException: Invalid format: "2014-01-15T14:23:50.026PST" is malformed at "PST"
    at org.joda.time.format.DateTimeFormatter.parseDateTime(DateTimeFormatter.java:866)
    at time.JodaTest8.main(JodaTest8.java:83)