DateTime start = 
  DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS")
    .withZoneUTC()
    .parseDateTime("2016-01-01 16:30:00.00000".substring(0, 23));
System.out.println(start); // 2016-01-01T16:30:00.000Z
DateTime end = ...;
Interval interval = new Interval(start, end);