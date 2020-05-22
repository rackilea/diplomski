private  String starString(int n){          
  StringBuilder s = new StringBuilder();
  for( int i = 0; i <= n; i++ ) {
    s.append("*");
  }
  return s.toString();
}