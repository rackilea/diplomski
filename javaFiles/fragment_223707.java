public boolean isInteger( String input ) {

  try {
    Integer.parseInt( input );
    return true;
   }
    catch( Exception e ) {
    return false;
   }
}