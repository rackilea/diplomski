static int nSpaces ( String s ) {
    int n = 0;
    if ( s.length() > 0 ) {
      if ( s.length() > 1 ) {
        // Split it in half.
        int center = s.length() / 2;
        // Count each half.
        n += nSpaces(s.substring(0, center))
           + nSpaces(s.substring(center));
      } else {
        // Just 1 character.
        if ( s.charAt(0) == ' ' ) {
          // It's a space.
          n += 1;
        }
      }
    }
    //System.out.println(n+" spaces in '"+s+"'");
    return n;
  }

  static int nWords ( String s ) {
    return nSpaces (s) + 1;
  }

  public static void main(String args[]) {
    String test = "Now is the time for all good men to come to the aid of the party.";
    System.out.println("nWords(\""+test+"\") = "+nWords(test));
  }