/* Cleans up often very bad xml. 
 * 
 * 1. Strips leading white space.
 * 2. Recodes &pound; etc to &#...;.
 * 3. Recodes lone & as &amp.
 * 
 */
public class XMLInputStream extends FilterInputStream {

  private static final int MIN_LENGTH = 2;
  // Everything we've read.
  StringBuilder red = new StringBuilder();
  // Data I have pushed back.
  StringBuilder pushBack = new StringBuilder();
  // How much we've given them.
  int given = 0;
  // How much we've read.
  int pulled = 0;

  public XMLInputStream(InputStream in) {
    super(in);
  }

  public int length() {
    // NB: This is a Troll length (i.e. it goes 1, 2, many) so 2 actually means "at least 2"

    try {
      StringBuilder s = read(MIN_LENGTH);
      pushBack.append(s);
      return s.length();
    } catch (IOException ex) {
      log.warning("Oops ", ex);
    }
    return 0;
  }

  private StringBuilder read(int n) throws IOException {
    // Input stream finished?
    boolean eof = false;
    // Read that many.
    StringBuilder s = new StringBuilder(n);
    while (s.length() < n && !eof) {
      // Always get from the pushBack buffer.
      if (pushBack.length() == 0) {
        // Read something from the stream into pushBack.
        eof = readIntoPushBack();
      }

      // Pushback only contains deliverable codes.
      if (pushBack.length() > 0) {
        // Grab one character
        s.append(pushBack.charAt(0));
        // Remove it from pushBack
        pushBack.deleteCharAt(0);
      }

    }
    return s;
  }

  // Returns true at eof.
  // Might not actually push back anything but usually will.
  private boolean readIntoPushBack() throws IOException {
    // File finished?
    boolean eof = false;
    // Next char.
    int ch = in.read();
    if (ch >= 0) {
      // Discard whitespace at start?
      if (!(pulled == 0 && isWhiteSpace(ch))) {
        // Good code.
        pulled += 1;
        // Parse out the &stuff;
        if (ch == '&') {
          // Process the &
          readAmpersand();
        } else {
          // Not an '&', just append.
          pushBack.append((char) ch);
        }
      }
    } else {
      // Hit end of file.
      eof = true;
    }
    return eof;
  }

  // Deal with an ampersand in the stream.
  private void readAmpersand() throws IOException {
    // Read the whole word, up to and including the ;
    StringBuilder reference = new StringBuilder();
    int ch;
    // Should end in a ';'
    for (ch = in.read(); isAlphaNumeric(ch); ch = in.read()) {
      reference.append((char) ch);
    }
    // Did we tidily finish?
    if (ch == ';') {
      // Yes! Translate it into a &#nnn; code.
      String code = XML.hash(reference);
      if (code != null) {
        // Keep it.
        pushBack.append(code);
      } else {
        throw new IOException("Invalid/Unknown reference '&" + reference + ";'");
      }
    } else {
      // Did not terminate properly! 
      // Perhaps an & on its own or a malformed reference.
      // Either way, escape the &
      pushBack.append("&amp;").append(reference).append((char) ch);
    }
  }

  private void given(CharSequence s, int wanted, int got) {
    // Keep track of what we've given them.
    red.append(s);
    given += got;
    log.finer("Given: [" + wanted + "," + got + "]-" + s);
  }

  @Override
  public int read() throws IOException {
    StringBuilder s = read(1);
    given(s, 1, 1);
    return s.length() > 0 ? s.charAt(0) : -1;
  }

  @Override
  public int read(byte[] data, int offset, int length) throws IOException {
    int n = 0;
    StringBuilder s = read(length);
    for (int i = 0; i < Math.min(length, s.length()); i++) {
      data[offset + i] = (byte) s.charAt(i);
      n += 1;
    }
    given(s, length, n);
    return n > 0 ? n : -1;
  }

  @Override
  public String toString() {
    String s = red.toString();
    String h = "";
    // Hex dump the small ones.
    if (s.length() < 8) {
      // Separator just inserts the string between each.
      Separator sep = new Separator(" ");
      for (int i = 0; i < s.length(); i++) {
        h += sep.sep() + Integer.toHexString(s.charAt(i));
      }
    }
    return "[" + given + "]-\"" + s + "\"" + (h.length() > 0 ? " (" + h + ")" : "");
  }

  private boolean isWhiteSpace(int ch) {
    switch (ch) {
      case ' ':
      case '\r':
      case '\n':
      case '\t':
        return true;
    }
    return false;
  }

  private boolean isAlphaNumeric(int ch) {
    return ('a' <= ch && ch <= 'z') 
        || ('A' <= ch && ch <= 'Z') 
        || ('0' <= ch && ch <= '9');
  }
}