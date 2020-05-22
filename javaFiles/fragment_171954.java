void appendInBetween(StringBuilder resultStr, String s, int start, int end) {
  // Pass the whole input string and the bounds, rather than taking a substring.

  // Allocate roughly enough space up-front.
  resultStr.ensureCapacity(resultStr.length() + end - start);

  for (int i = start; i < end; ++i) {
    char c = s.charAt(i);

    // Check if c matches "([^\\p{L}\\p{N}\\p{Mn}_\\-<>'])".
    if (!(Character.isLetter(c)
          || Character.isDigit(c)
          || Character.getType(c) == Character.NON_SPACING_MARK
          || "_\\-<>'".indexOf(c) != -1)) {
      resultStr.append(' ');
      resultStr.append(c);
      resultStr.append(' ');
    } else if (c == '\'' && i > 0 && i + 1 < s.length()) {
      // We have a quote that's not at the beginning or end.
      // Call these 3 characters bcd, where c is the quote.

      char b = s.charAt(i - 1);
      char d = s.charAt(i + 1);

      if ((Character.isDigit(b) || Character.isLetter(b)) && Character.isLetter(d)) {
        // If the 3 chars match "([\\p{N}\\p{L}])'(\\p{L})"
        resultStr.append(' ');
        resultStr.append(c);
      } else if (!Character.isLetter(b) && !Character.isLetter(d)) {
        // If the 3 chars match "([^\\p{L}])'([^\\p{L}])"
        resultStr.append(' ');
        resultStr.append(c);
        resultStr.append(' ');
      } else {
        resultStr.append(c);
      }
    } else {
      // Everything else, just append.
      resultStr.append(c);
    }
  }
}