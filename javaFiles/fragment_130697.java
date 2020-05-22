LocalDate localDate = null ;
for( DateTimeFormatter f : formatters ) {
    try{
        localDate = LocalDate.parse( input , f ) ;
    } catch ( DateTimeParseException e ) {
        // Ignoring exception, as it is expected. 
    }
}
if( Objects.isNull( localDate ) ) { … deal with unexpected input }