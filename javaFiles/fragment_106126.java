Pattern pat = Pattern.compile( "^\\s*public\\s+class\\s+(\\w+).*$" );

String line = reader.readLine();
Matcher mat = pat.matcher( line );
if( mat.matches() ){
    String classname = mat.group( 1 );
    // ...
}