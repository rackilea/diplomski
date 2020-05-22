LocalDate localDate = new LocalDate().withMonthOfYear(3).withDayOfMonth(10);
LocalTime localTime = new LocalTime().withHourOfDay(2);
DateTime dateTime = localDate.toDateTime(localTime, DateTimeZone.UTC);
DateTime dt = new DateTime(DateTimeZone.UTC.getMillisKeepLocal(DateTimeZone.getDefault(), dateTime.getMillis()));

System.out.println(dateTime);
System.out.println(dt);