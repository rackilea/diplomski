DateTimeZone zone = DateTimeZone.forID( "America/Montreal" );
DateTime dateTime = new DateTime( yourJUDate, zone );  // Convert java.util.Date to Joda-Time, and assign time zone to adjust.
DateTime now = DateTime.now( zone );
// Now see if the month and year match.
if ( ( dateTime.getMonthOfYear() == now.getMonthOfYear() ) && ( dateTime.getYear() == now.getYear() ) ) {
    // You have a hit.
}