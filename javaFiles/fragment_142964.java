LocalTime localTime = new LocalTime( 13 , 15 );  // Quarter-hour after 1 PM.
System.out.println( "localTime: " + localTime );
DateTimeZone timeZone = DateTimeZone.forID( "America/Montreal" ); // Or DateTimeZone.UTC
DateTime today = localTime.toDateTimeToday( timeZone );
DateTime now = DateTime.now(); // You may want to pad an bit of extra time in case now is extremely close to midnight (new day).
if ( today.isBefore( now ) ) {
    // If the local time in question when applied to today has already past, then
    // adjust to tomorrow while accounting for Daylight Saving Time or other anomaly.
    DateTime tomorrowInitial = today.plusDays( 1 );  // Get tomorrow by adding 1 day to today.
    DateTime tomorrow = localTime.toDateTime( tomorrowInitial ); // DST or other anomaly may mean that tomorrow got adjusted to a different time-of-day. Override with our desired time-of-day.
    System.out.println( "tomorrow: " + tomorrow );
    // return tomorrow;
}
System.out.println( "today: " + today );
// return today;