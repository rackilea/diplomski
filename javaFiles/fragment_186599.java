String string1 = "Oct 15, 2012 1:07:13 PM";
String string2 = "Oct 23, 2012 03:43:34 PM";

DateTimeFormatter dtf = DateTimeFormat.forPattern("MMM d, yyyy h:mm:ss a").withLocale(Locale.ENGLISH);

DateTime dateTime1 = dtf.parseDateTime(string1);
DateTime dateTime2 = dtf.parseDateTime(string2);
Period period = new Period(dateTime1, dateTime2);

PeriodFormatter formatter = new PeriodFormatterBuilder()
    .appendYears().appendSuffix(" years ")
    .appendMonths().appendSuffix(" months ")
    .appendWeeks().appendSuffix(" weeks ")
    .appendDays().appendSuffix(" days ")
    .appendHours().appendSuffix(" hours ")
    .appendMinutes().appendSuffix(" minutes ")
    .appendSeconds().appendSuffix(" seconds ")
    .printZeroNever()
    .toFormatter();

String elapsed = formatter.print(period);
System.out.println(elapsed);