static String zin(String zin) {
  int i = 0;
  int length = zin.length();

  for ( i = 0; i < zin.length(); i++ ) {
    int ascii = (int)zin.charAt(i);
    System.out.println(ascii);
  }

  return zin;
}