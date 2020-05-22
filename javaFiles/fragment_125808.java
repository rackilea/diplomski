YearMonth thisMonth    = YearMonth.now();
YearMonth lastMonth    = thisMonth.minusMonths(1);
YearMonth twoMonthsAgo = thisMonth.minusMonths(2);

DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");

System.out.printf("Today: %s\n", thisMonth.format(monthYearFormatter));
System.out.printf("Last Month: %s\n", lastMonth.format(monthYearFormatter));
System.out.printf("Two Months Ago: %s\n", twoMonthsAgo.format(monthYearFormatter));