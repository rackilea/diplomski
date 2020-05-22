int num[] = { 50 , 20 , 45 , 82 , 25 , 63 };
ByteBuffer bb = ByteBuffer.allocate( num.length * 4 );
for ( int i : num ) {
    bb.putInt( i );
}
byte[] data = bb.array();