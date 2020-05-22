public static int matchPosition(byte [] a, byte [] b){
      int matchLength=0;
      int maxSearch = 30>a.length?a.length:30;
    for (int i =0;i<maxSearch;i++) {
      if (a[i]==b[0] && i+b.length<a.length){
          for(int j = 0;j< b.length;j++ )
          {
              if((i+j)==a.length-1)
                  return -1;
              if(a[i+j]==b[j])
                  matchLength++;
          }
          if(matchLength == b.length)
              return i;
          else
              matchLength = 0; 
      }
    }
    return -1; 
  }


private static byte[] fromHexString(final String encoded) {
    if ((encoded.length() % 2) != 0)
        throw new IllegalArgumentException("Input string must contain an even number of characters");

    final byte result[] = new byte[encoded.length()/2];
    final char enc[] = encoded.toCharArray();
    for (int i = 0; i < enc.length; i += 2) {
        StringBuilder curr = new StringBuilder(2);
        curr.append(enc[i]).append(enc[i + 1]);
        result[i/2] = (byte) Integer.parseInt(curr.toString(), 16);
    }
    return result;
}