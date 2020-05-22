LocalDate today = LocalDate.now( ZoneOffset.UTC ) ;
Instant instant = myResultSet.getObject( … , Instant.class ) ;  // Retrieve a `TIMESTAMP WITH TIME ZONE` value in database as an `Instant` for a date with time-of-day in UTC with a resolution as fine as nanoseconds.
LocalDate ld = instant.atOffset( ZoneOffset.UTC ).toLocalDate() ;  // Extract a date-only value without time-of-day and without time zone.

if ( ld.isBefore( today ) ) { … }       // Compare `LocalDate` objects.
else if ( ld.isEqual( today ) ) { … }
else if ( ld.isAfter( today ) ) { … }
else { … handle error }