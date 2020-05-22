private void a2( List<String> args ) {

    List<String> newList = new ArrayList<>( );
    newList.add("foo"); 
    newList.addAll( args );

    b( newList );
}