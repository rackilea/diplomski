int dup = 0;
int abs = 0;
BitSet present = new BitSet( a.size() + 1 );
for( int x: a ){
    if( present.get( x ) ){
        dup = x;
    } else {
        present.set( x );
    }
}
abs = present.nextClearBit( 1 );