public static String toBinaryString(int i) {
     return toUnsignedString(i, 1);
 }

 private static String toUnsignedString(int i, int shift) {
     char[] buf = new char[32];
     int charPos = 32;
     int radix = 1 << shift;
     int mask = radix - 1;
     do {
         buf[--charPos] = digits[i & mask];
         i >>>= shift;
     } while (i != 0);
     return new String(buf, charPos, (32 - charPos));
 }