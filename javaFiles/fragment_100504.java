public int[] bytearray2intarray(byte[] barray)
 {
   int[] iarray = new int[barray.length];
   int i = 0;
   for (byte b : barray)
       iarray[i++] = b & 0xff;
   // "and" with 0xff since bytes are signed in java
   return iarray;
 }