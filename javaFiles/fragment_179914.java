String[] formats = { "dd MMM. yyyy", "dd MM yyyy" };
String[] patterns = { "\\d+ [a-zA-Z]+\. \d{4}", "\\d+ [a-zA-Z]+ \d{4}" };

for ( int i = 0; i < patterns.length; i++ )
{
  // Create a Pattern object
  Pattern r = Pattern.compile(patterns[ i ] );

  // Now create matcher object.
  Matcher m = r.matcher( theDateString );

  if (m.find( )) {
     return new SimpleDateFormat( formats[ i ] ).parse( theDateString );
  }
}