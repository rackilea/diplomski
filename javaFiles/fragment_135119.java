final Pattern pattern = Pattern.compile( "(\\w+)" );
final Matcher matcher = pattern.matcher( input );
while( matcher.find()) {
   final String word = matcher.group( 1 );
   output.append( ' ' );
   if( word.charAt( 0 ) == 'k' ) {
      output.append( word );
   }
   else {
      for( int i = 0; i < word.length(); ++i ) {
         output.append( 1 + word.charAt( i ) - 'a' );
      }
   }
}