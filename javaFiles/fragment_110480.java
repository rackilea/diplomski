String str = "...sinking will be 44% successful...";
Pattern p = Pattern.compile( "sinking will be (\\S*) successful" );
Matcher m = p.matcher( str );
if ( m.find() ) {
    String percent = m.group( 1 );
}