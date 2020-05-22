DateTime dateTime1 = new DateTime("2001-07-04T12:08:56.235-07:00");
System.out.println(dateTime1);
System.out.println(dateTime1.getZone());

DateTime dateTime2 = DateTime.parse("2001-07-04T12:08:56.235-07:00");
System.out.println(dateTime2);
System.out.println(dateTime2.getZone());