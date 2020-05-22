Date utdDate = new Date();
DateTime dateTime = new DateTime(utdDate, DateTimeZone.UTC);
System.out.println(dateTime); // 2014-04-16T16:51:31.195Z

dateTime = dateTime.withZone(DateTimeZone.forID("Europe/Berlin"));
System.out.println(dateTime); // 2014-04-16T18:51:31.195+02:00