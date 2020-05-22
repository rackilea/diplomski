public String getLastgame() {

    long time = ((System.currentTimeMillis() / 60000) - this.config.getLastgameTime());

    long oneYear = 60 * 24 * 365;
    long oneDay = 60 * 24;
    long oneHour = 60;

    // extract years
    int years = time / oneYear;
    // update your time
    time = time % oneYear;

    // extract days
    long days = time / oneDay;
    // update your time
    time = time % oneDay;

    // extract hours    
    long hours = time / oneHour;

    // extract minutes (the remaining)
    minutes = time % oneHour;

    StringBuilder sb = new StringBuilder( "Last time " );
    if ( years != 0 ) {
        sb.append( years ).append( "y " );
    }
    if ( days != 0 ) {
        sb.append( days ).append( "d " );
    }
    if ( hours != 0 ) {
        sb.append( hours ).append( "h " );
    }
    if ( minutes != 0 ) {
        sb.append( minutes ).append( "m " );
    }
    sb.append( " ago" );

    return sb.toString();

}