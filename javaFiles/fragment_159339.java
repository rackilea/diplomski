public void moveItem( int idxToMove , int targetIdx ) {
    //move the item as I did with Strings

    for ( int i=0 ; i<list.size() ; i++ ) {
        list.get( i ).position = i;
    }
}