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