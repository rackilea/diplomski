// © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.
// import org.joda.time.*;
// import org.joda.time.format.*;

DateTimeZone timeZone = DateTimeZone.forID( "Europe/Paris" );

java.util.List<DateTime> dateTimesInput = new ArrayList<DateTime>();
dateTimesInput.add( new DateTime( 2001, 2, 3, 4, 5, 6, timeZone ) );
dateTimesInput.add( new DateTime( 2014, 1, 5, 7, 8, 9, timeZone ) );
dateTimesInput.add( new DateTime( timeZone ).minusDays( 2 ) );

// Calculate the moment of a month ago, in desired time zone. Include all of that moment’s day, so go back to first moment of the day.
DateTime monthAgo = new DateTime( timeZone ).minusMonths( 1 ).withTimeAtStartOfDay();

// Loop the dates input. If any are less than a month old, keep them.
java.util.List<DateTime> keepers = new ArrayList<DateTime>();
for(DateTime dateTime: dateTimesInput){
    if( dateTime.isBefore( monthAgo ) ){
        // Ignore this date-time.
    } else {
        keepers.add( dateTime );
    }
}

// Dump to console.
System.out.println( "Month ago: " + monthAgo );
for(DateTime dateTime: keepers){
    System.out.println( dateTime );
}