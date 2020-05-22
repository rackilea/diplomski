YearMonth from = YearMonth.of(2012, Month.MAY);
    YearMonth to = YearMonth.of(2013, Month.NOVEMBER);

    String format = "%1$-3tb %1$tY - %2$-3tb %2$tY";
    String dateString = String.format(Locale.GERMAN, format, from, to);

    System.out.println(dateString);