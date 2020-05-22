DateTime myBirthDate = new DateTime(1978, 3, 26, 12, 35, 0, 0);
DateTime now = new DateTime();
Period period = new Period(myBirthDate, now);

PeriodFormatter formatter = new PeriodFormatterBuilder()
    .appendYears().appendSuffix(" year, ", " years, ")
    .appendMonths().appendSuffix(" month, ", " months, ")
    .appendWeeks().appendSuffix(" week, ", " weeks, ")
    .appendDays().appendSuffix(" day, ", " days, ")
    .appendHours().appendSuffix(" hour, ", " hours, ")
    .appendMinutes().appendSuffix(" minute, ", " minutes, ")
    .appendSeconds().appendSuffix(" second", " seconds")
    .printZeroNever()
    .toFormatter();

String elapsed = formatter.print(period);
System.out.println(elapsed + " ago");