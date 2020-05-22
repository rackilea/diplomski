PeriodFormatter yearsAndMonths = new PeriodFormatterBuilder()
 .printZeroAlways()
 .appendYears()
 .appendSuffix(" year", " years")
 .appendSeparator(" and ")
 .printZeroRarelyLast()
 .appendMonths()
 .appendSuffix(" month", " months")
 .toFormatter();