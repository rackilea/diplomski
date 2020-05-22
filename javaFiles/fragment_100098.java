private static boolean stringMatches(String s) {
  // Handle empty and null cases first.
  if (s == null || s.isEmpty()) return false;

  // So long as the string continues to match the pattern, keep stripping
  // characters from it until it is empty. If you reach empty, it matches the pattern.
  while (! s.isEmpty()) {
    // If the first character isn't 'a', we don't match; return false.
    if (s.charAt(0) != 'a') {
      return false;
    }

    // Check for abb, if so strip all of that, otherwise strip just the a
    if (s.length() >= 3 && "abb".equals(s.substring(0,3)) {
      s = s.substring(3);
    } else {
      s = s.substring(1);
    }
  }
  // Reached empty string, return true.
  return true;
}