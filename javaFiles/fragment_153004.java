// © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.
// import org.joda.time.*;

// Generally best to be explicit about time zone rather than depend on default.
DateTimeZone denverTimeZone = DateTimeZone.forID( "America/Denver" );
java.util.Locale locale = Locale.FRANCE;

DateTime now = new DateTime( denverTimeZone );

System.out.println( "Current Year, Month & Day for: " + now );
System.out.println( "Year is " + now.year().getAsText( locale ) );
System.out.println( "Month is " + now.monthOfYear().getAsText( locale ) );
System.out.println( "Day is " + now.dayOfMonth().getAsText( locale ) );
System.out.println(); // blank line.