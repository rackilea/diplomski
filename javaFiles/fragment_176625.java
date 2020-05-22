final String input = "-100,+300,-500,56.9,-98.6";
Pattern pattern = Pattern.compile( "[+-][0-9]+.?[0-9]*" );
Matcher matcher = pattern.matcher( input );
while ( matcher.find() ) {
    System.out.println( matcher.group( 0 ) );
}