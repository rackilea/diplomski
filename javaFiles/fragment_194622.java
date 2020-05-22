LocalTime lt = LocalTime.parse("6:00 am", 
                new DateTimeFormatterBuilder().
                                appendHourOfDay(1).
                                appendLiteral(":").
                                appendMinuteOfHour(1).
                                appendLiteral(" ").
                                appendHalfdayOfDayText().toFormatter());
LocalTime midnight = LocalTime.MIDNIGHT;
Duration duration = new Duration(midnight.toDateTimeToday(), lt.toDateTimeToday());
System.out.println(duration.toStandardSeconds().getSeconds());