public int count7(int n) {
  int counter = 0;

  if( n % 10 == 7) counter++;

  if( n / 10  == 0)  return counter;

  return counter + count7(n/10); 
}