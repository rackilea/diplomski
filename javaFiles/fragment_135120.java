final String[] words = input.split( "\\W+" ) ;
for( final String word : words ) {
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