ChronoInterval<PlainTimestamp> missed0 = missed.get(0);
PlainTimestamp tsp = missed0.getStart().getTemporal();
LocalDateTime ldt = // joda-equivalent
    new LocalDateTime(
        tsp.getYear(), tsp.getMonth(), tsp.getDayOfMonth(), 
        tsp.getHour(), tsp.getMinute(), tsp.getSecond(), tsp.get(PlainTime.MILLI_OF_SECOND));
System.out.println(ldt); // 2016-01-01T10:00:00.000