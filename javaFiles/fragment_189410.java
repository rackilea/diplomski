DateTime dateTime = DateTime.parse("2015-09-04T08:37:00.440-07:00");
System.out.println(dateTime);
System.out.println(dateTime.toString("EEEE, MMM d 'at' hh:mm a"));

dateTime = dateTime.withZone(DateTimeZone.getDefault());
System.out.println(dateTime);
System.out.println(dateTime.toString("EEEE, MMM d 'at' hh:mm a"));

dateTime = dateTime.withZone(DateTimeZone.UTC);
System.out.println(dateTime);
System.out.println(dateTime.toString("EEEE, MMM d 'at' hh:mm a"));