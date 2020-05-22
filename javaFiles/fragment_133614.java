Pattern tokens = Pattern.compile( "([a-zA-Z0-9]+):\\s*(\\w+(?:,?\\w+)*)" );

Matcher m = tokens.matcher( myString );
while( m.find() ) {
    System.out.println( "tag:" + m.group(1) + "  value:" + m.group(2) );
}