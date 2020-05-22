ZoneId z = ZoneId.of( "America/Montreal" ) ;
ZonedDateTime zdt = ZonedDateTime.now( z ) ;
long minutesIntoTheDay = ChronoUnit.MINUTES.between( 
    zdt.toLocalDate().atStartOfDay( z ) ,
    zdt 
);