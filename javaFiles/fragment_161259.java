Date utdDate = new Date();
dateTime = new DateTime(utdDate, DateTimeZone.UTC);
System.out.println(dateTime); // 2014-04-16T16:49:08.394Z

dateTime = dateTime.withZoneRetainFields(DateTimeZone.forID("Europe/Berlin"));
System.out.println(dateTime); // 2014-04-16T16:49:08.394+02:00