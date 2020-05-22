static String[] split( String in ) {
   List< String > list = new LinkedList< String >();
   int dot = 0;
   for( int i = 0; dot > -1 && i < in.length(); i = dot + 7 ) {
      dot = in.indexOf( '.', i );
      if( dot > -1 ) {
         int last = Math.min( dot + 7, in.length());
         list.add( in.substring( i, last ));
      }
   }
   return list.toArray( new String[list.size()]);
}