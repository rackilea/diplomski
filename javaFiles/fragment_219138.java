ZoneId z = ZoneId.of ( "America/Montreal" );
ZonedDateTime zdt = ZonedDateTime.now ( z );

List<Locale> locales = new ArrayList<> ();
locales.add ( Locale.US );
locales.add ( Locale.CANADA_FRENCH );
locales.add ( Locale.TAIWAN );
locales.add ( new Locale ( "hi" , "IN" ) );  // Hindi, India.
// locales.add ( new Locale ( "ar" , "MA" ) );  // Arabic, Morocco

EnumSet<FormatStyle> formatStyles = EnumSet.allOf ( FormatStyle.class );

for ( Locale locale : locales ) {
    System.out.println ( "—————" );
    System.out.println ( "Locale: " + locale );
    for ( FormatStyle formatStyle : formatStyles ) {
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime ( formatStyle ).withLocale ( locale );
        System.out.println ( String.format ( "%1$-" + 20 + "s" , "FormatStyle: " + formatStyle ) + "  →  " + zdt.format ( f ) );
    }
}
System.out.println ( "—————" );