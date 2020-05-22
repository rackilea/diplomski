String input = "2016-07-11T16:50:22.00"; // "2016-07-11T16:50:22.00+05:00";
Boolean hasOffset = null;
try {
    OffsetDateTime odt = OffsetDateTime.parse ( input );
    hasOffset = Boolean.TRUE;
    ZoneOffset offset = odt.getOffset ();
    System.out.println ( "input: " + input + " | hasOffset: " + hasOffset + " | odt: " + odt + " | offset: " + offset );
} catch ( java.time.format.DateTimeParseException e1 ) {
    // Perhaps input lacks offset-from-UTC. Try parsing as a local date-time.
    try {
        LocalDateTime ldt = LocalDateTime.parse ( input );
        hasOffset = Boolean.FALSE;
        System.out.println ( "input: " + input + " | hasOffset: " + hasOffset + " | ldt: " + ldt );
    } catch ( java.time.format.DateTimeParseException e2 ) {
        System.out.println ( "ERROR - Unexpected format in the input string" ); // FIXME: Handle format exception.
    }
}