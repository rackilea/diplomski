String input = "P3D"; // 3 days. Three hours would be "PT3H", as another example.

// Get current date-time.
DateTimeZone timeZone = DateTimeZone.forID( "Pacific/Honolulu" );
DateTime now = new DateTime( timeZone );

// Shift from current date-time by a Period specified by ISO "Duration" string.
// Yes, these date-time terms (period, duration, interval) are all mixed up. 
// An effort to standardize such terms is underway. But for now, get used to it and "translate".
Period period = new Period( input );
DateTime dateTime = now.plus( period );