public static DateTime convertDateTimeToTimeZone(final DateTime dateTime, final int hour, final int minute,
        final int second,
        final DateTimeZone dtzConversion, final DateTimeZone dtzReturn)
{
    // convert to given timezone        
    DateTime dtClientTimezone = dateTime.withZone(dtzConversion);
    // adjust time
    dtClientTimezone = dtClientTimezone.withTime(hour, minute, second, 0);

    if (dtzReturn != null) {
        // convert to target timezone
        dtClientTimezone = dtClientTimezone.withZone(dtzReturn);
    }

    return dtClientTimezone;
}

public static void main(String[] args)
{
    DateTime parse = DateTime.parse("2015-09-30T22:00:00Z");
    DateTime convertDateTimeToTimeZone = convertDateTimeToTimeZone(parse, 12, 0, 0, DateTimeZone.forOffsetHours(2), DateTimeZone.UTC);
    System.out.println(convertDateTimeToTimeZone);
}