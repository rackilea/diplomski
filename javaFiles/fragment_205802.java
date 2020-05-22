private void a2( List<String> args ) {

    List<String> newList = new ArrayList<>( args );
    newList.add(0, "foo"); // <-- Extra O(n) time to shift elements over.

    b( newList );
}