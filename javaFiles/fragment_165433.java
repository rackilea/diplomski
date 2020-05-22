DateTime dateTimePlus2 = DateTime.parse("2015-07-09T05:10:00+02:00");
System.out.println(dateTimePlus2);

DateTime dateTimeUTC = dateTimePlus2.withZone(DateTimeZone.UTC);
System.out.println(dateTimeUTC);

LocalDateTime localDateTimeUTC = dateTimeUTC.toLocalDateTime();
System.out.println(localDateTimeUTC);