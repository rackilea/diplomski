public static int lcsrec(String x, String y) {

    // If one of the strings has one character, search for that character
    // in the other string and return the appropriate answer.
    if (x.length() == 1) 
      return find(x.charAt(0), y);
    if (y.length() == 1)
      return find(y.charAt(0), x);

    // Solve the problem recursively.

    // Corresponding beginning characters match.
    if (x.charAt(0) == y.charAt(0))
      return 1+lcsrec(x.substring(1), y.substring(1));

    // Corresponding characters do not match.
    else 
      return max(lcsrec(x,y.substring(1)), lcsrec(x.substring(1),y));

  }