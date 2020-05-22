public void moveItemById( int itemId , int newPosition ) {
    int positionOfItem = -1;
    for ( int i=0 ; i<list.size() ; i++ ) {
        if ( list.get( i ).id == itemId ) {
            positionOfItem = i;
            break;
        }
    }
    if ( positionOfItem != -1 ) {
        moveItem( positionOfItem , newPosition );
    }
}