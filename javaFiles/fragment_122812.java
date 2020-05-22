public void nextBytes(byte[] bytes) {    for (int i = 0; i <
 bytes.length; )
      for (int rnd = nextInt(), n = Math.min(bytes.length - i, 4);
           n-- > 0; rnd >>= 8)
       bytes[i++] = (byte)rnd; 
 }