int pow(int base, int power) { //assume power to be > 1
  int result = base;

  for( int i = 1; i <= power; i++ ) 
    System.out.println( base + " pow( " + i + ") = " + result );
    result *= base;

  return result;
}