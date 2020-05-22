private static String shortestPalindrome(String s) {
    int j = s.length();
    while (!isPalindrome(s.substring(0, j))) {
        j--;
    }
     String suffix = s.substring(j);
    // Similar to OP's original code, excluding the recursion.
    return new StringBuilder(suffix).reverse()
              .append(s.substring(0, j))
              .append(suffix)
              .toString();  
}