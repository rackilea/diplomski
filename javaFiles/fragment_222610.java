// © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.
// import org.joda.time.*;
// import org.joda.time.format.*;

DateTime nowInParis = new DateTime( DateTimeZone.forID( "Europe/Paris" ) );

DateTimeFormatter formatter = DateTimeFormat.forPattern("E, d MMM yyyy HH:mm:ss 'GMT'").withLocale( Locale.US );
String nowInParisAsStringGMT = formatter.print( nowInParis.toDateTime( DateTimeZone.UTC ) );