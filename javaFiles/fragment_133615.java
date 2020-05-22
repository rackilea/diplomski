Pattern main = Pattern.compile( "([a-zA-Z0-9]+):" );
Matcher m = main.matcher(myString);
int lastStart = 0;
while( m.find() ) {
    if( lastStart != 0 ) {
        processToken( myString.substring(lastStart, m.start()) );
    }
    lastStart = m.start();
}
processToken( myString.substring(lastStart) );