YearMonth ym = new YearMonth(2012, DateTimeConstants.MARCH);
    Interval interval = ym.toInterval();
    LocalDate monthStart = interval.getStart().toLocalDate();
    LocalDate monthEnd = interval.getEnd().toLocalDate();

    System.out.println("Start:" + monthStart);
    System.out.println("End: " + monthEnd);