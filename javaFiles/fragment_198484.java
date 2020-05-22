Date datePart= ...;           // The date parsed from the first user input
String userTimeInput = ...;   // The time of day from the user
Locale userLocale = ...;
DateTimeZone userTimeZone = ...;

DateTime dateInUserTimeZone = new DateTime(datePart, userTimeZone);
DateTimeFormatter formatter = DateTimeFormat.shortTime().withLocale(userLocale);
LocalTime time = formatter.parseLocalTime(userTimeInput);

Date newDate = dateInUserTimeZone.withTime(time.getHourOfDay(), time.getMinuteOfHour(),
        time.getSecondOfMinute(), time.getMillisOfSecond()).toDate();