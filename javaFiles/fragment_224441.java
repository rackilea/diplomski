int[] finalArray = new int[ 2 * N ];

for ( int i = 0; i < N; i++ ){

    finalArray[ 2 * i ] = array1[ i ];
    finalArray[ 2 * i + 1 ] = array2[ array2.length - i - 1 ];

}