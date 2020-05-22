public static char toHexChar(int i) {
  i&=15;
  return (i<10)? (char)(i+48) : (char)(i+55);
 }

 public static String toHexString(int n) {
  char[] chars=new char[8];
  for (int i=0; i<8; i++) {
   chars[7-i]=toHexChar(n);
   n>>=4;
  };
  return new String(chars);
 }