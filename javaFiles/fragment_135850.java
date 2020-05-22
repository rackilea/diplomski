String original = "Fri, 13 Apr 2018 02:26:19 -0700 (PDT)";
// Delete non-standard pseudo-zone at end.
String input = original;
if ( input.endsWith( ")" ) ) {
    int index = input.indexOf( " (" );
    input = input.substring( 0 , index );
}
DateTimeFormatter f = DateTimeFormatter.RFC_1123_DATE_TIME;
OffsetDateTime odt = OffsetDateTime.parse( input , f );