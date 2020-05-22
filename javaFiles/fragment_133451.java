public static BigInteger StringLayer( char[] str, char[] a )
  {

    char[] target = Arrays.copyOf( str, str.length );

    int index = 0;
    for ( int i = 0; i < target.length; i++ )
    {
      if ( str[ i ] == '-' )
      {
        target[ i ] = a[ index ];
        index++;
      }
    }
    return new BigInteger( new String( target ) );
  }