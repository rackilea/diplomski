private static String escapeNonAscii(String str) {

  StringBuilder retStr = new StringBuilder();
  for(int i=0; i<str.length(); i++) {
    int cp = Character.codePointAt(str, i);
    int charCount = Character.charCount(cp);
    if (charCount > 1) {
      i += charCount - 1; // 2.
      if (i >= str.length()) {
        throw new IllegalArgumentException("truncated unexpectedly");
      }
    }

    if (cp < 128) {
      retStr.appendCodePoint(cp);
    } else {
      retStr.append(String.format("\\u%x", cp));
    }
  }
  return retStr.toString();
}