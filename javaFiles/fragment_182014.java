LocalTime now = LocalTime.now( ZoneId.of( "America/Montreal" ) );
Boolean isNowWithinRange =
    ( 
        ( ! now.isBefore( LocalTime.parse( "11:00:00" ) ) ) 
        && now.isBefore( LocalTime.parse( "12:00:00" ) 
    ) ;