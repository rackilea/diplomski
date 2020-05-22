String[] X = new String[] {"AAA", "BBB", "CCC", "DDD"};
int XL = X.length;

for (int i=0; i<XL; i++) {
  println("i:" +X[i] +" j:" + X[(i+1)%XL] );
}