void printPath( int n ) {
    if ( n != -1 ) {
        printPath( path[n] );
        System.out.print( n );
    }
}