// Usually better to specify a time zone than rely on default.
DateTimeZone timeZone = DateTimeZone.forID( "Asia/Hong_Kong" );
DateTimeFormatter formatter = DateTimeFormat.forPattern( "MM/dd/yyyy" ).withZone( timeZone );

// Parse string into a DateTime. Define the format.
String input = "05/05/2013";
DateTime dateTime = formatter.parseDateTime( input ); // Defaults to first moment of the day.

// Render date-time as an ISO 8601 string. The "toString" method on DateTime defaults to a built-in ISO 8601 formatter.
// A DateTime object is not itself a string. But a DateTime can generate a string by calling its "toString" method.
String iso8601String = dateTime.toString();

// Parse string into a DateTime. Passing to constructor conveniently uses the built-in ISO 8601 parser built into DateTime class.
DateTime dateTime2 = new DateTime( iso8601String, timeZone );

// Render date-time as a string in a particular format.
String output = formatter.print( dateTime2 );