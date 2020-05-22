public static int[] eliminate( int[] x, int b) {
  BitSet bs = Bits.convert( b );
  int[] X = new int[x.length];

  for( int i = 0; i < x.length; i++){
    if( bs.get( x.length - (i + 1) ) ){
      X[i] = x[i];
    }
    else {
      X[i] = 0;
    }
  }

  return X;
}