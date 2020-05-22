int size = left.size();
int diff = size - right.size();
if( diff != 0 ) return diff;
for( int i = 0; i < size; ++i ) {
   diff = left.get( i ).compareTo( right.get(i) );
   if( diff != 0 ) return diff;
}