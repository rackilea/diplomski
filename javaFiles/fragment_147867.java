/**
 * Parse and format base 32 numbers.
 *
 * Some of this may apply to almost any format but there's much that won't
 * such as allowing both uppercase and lowercase forms of each digit.
 *
 * See: http://en.wikipedia.org/wiki/Base32
 */
public class Base32 {
      // The character sets.
  // Like Hex but up to V
  private static final String base32HexCharacterSet = "0123456789ABCDEFGHIJKLMNOPQRSTUV";
  // Common alternative - avoids O/0, i/1 etc.
  private static final String base32CharacterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
  // Avoids vowels (and therefore real words)
  private static final String zBase32CharacterSet = "YBNDRFG8EJKMCPQXOT1UWISZA345H769";
  // Avoids o/0 confusion.
  private static final String crockfordCharacterSet = "0123456789ABCDEFGHJKMNPQRSTVWXYZ";
      // Known/published formats.
  // Uses the BigInteger formatter.
  public static final Base32 ordinary = new Base32();
  // A lot like the BigInteger formatter - but using my mechanism.
  public static final Base32 base32Hex = new Base32(base32HexCharacterSet);
  // The RFC 4648 Base32.
  public static final Base32 base32 = new Base32(base32CharacterSet);
  // Supposedly more natural than RFC 4648.
  public static final Base32 zBase32 = new Base32(zBase32CharacterSet);
  // Much like normal but recodes some similar looking characters to the same character.
  public static final Base32 crockfords = new Base32(crockfordCharacterSet, "O0", "o0", "L1", "l1", "I1", "i1");
  // Invalid character.
  private static final int Invalid = -1;
  // The radix - fixed at 32 bits.
  private static final int radix = 32;
  // The bits per digit - could use (int) (Math.log(radix) / Math.log(2))
  private static final int bitsPerDigit = 5;
  // The bits per byte.
  private static final int bitsPerByte = 8;
  // Translation table for each code.
  private final char[] formatTable;
  // Translation table for each character.
  private final int[] parseTable;

  // Constructor - Probably should be private but why restrict the user.
  public Base32() {
    // Empty tables makes us match BigInteger format so no formatting/parsing is required.
    formatTable = null;
    parseTable = null;
  }

  // Constructor with character set and optional extras :).
  protected Base32(String characterSet, String... extras) {
    // Check the character set against the radix.
    if (characterSet.length() != radix) {
      throw new NumberFormatException("Invalid character set. Must be " + radix + " long");
    }
    // Build the format table.
    formatTable = buildFormatTable(characterSet);
    // And the parse table.
    parseTable = buildParseTable(characterSet, extras);
  }

  // Build a format table from the character set.
  private char[] buildFormatTable(String characterSet) {
    // Start clear.
    char[] table = new char[radix];
    // Put each character from the character set in.
    for (int i = 0; i < radix; i++) {
      table[i] = characterSet.charAt(i);
    }
    return table;
  }

  private int[] buildParseTable(String characterSet, String... extras) {
    // Handle all characters up to and including 'z'.
    int[] table = new int['z' + 1];
    // By default invalid character.
    Arrays.fill(table, Invalid);
    // Lowercase and uppercase versions.
    String lc = characterSet.toLowerCase();
    String uc = characterSet.toUpperCase();
    // Walk through the character set.
    for (int i = 0; i < radix; i++) {
      char l = lc.charAt(i);
      char u = uc.charAt(i);
      // Something wrong if we've already filled this one in.
      if (table[l] == Invalid && table[u] == Invalid) {
        // Put both lowercase and uppercase forms in the table.
        table[l] = i;
        table[u] = i;
      } else {
        // Failed.
        throw new NumberFormatException("Invalid character set - duplicate found at position " + i);
      }
    }
    // Add extras.
    for (String pair : extras) {
      // Each Must be length 2.
      if (pair.length() == 2) {
        // From
        int f = pair.charAt(1);
        // To
        int t = pair.charAt(0);
        // Something wrong if we've already filled this one in or we are copying from one that is not filled in.
        if (table[f] != Invalid && table[t] == Invalid) {
          // EG "O0" means a capital oh should be treated as a zero.
          table[t] = table[f];
        } else {
          // Failed.
          throw new NumberFormatException("Invalid character set extra - copying from " + f + " to " + t);
        }
      } else {
        // Failed.
        throw new NumberFormatException("Invalid extra \"" + pair + "\" - should be 2 characters wide.");
      }

    }
    return table;
  }

  // Format a BigInteger.
  public String format(BigInteger n) {
    // Get its raw Radix32 string - in uppercase.
    String formatted = n.toString(radix).toUpperCase();
    // Further formatting through the format table?
    if (formatTable != null) {
      // Translate it.
      char[] translated = new char[formatted.length()];
      for (int i = 0; i < formatted.length(); i++) {
        // Use Character.digit to decode the digit value.
        int d = Character.digit(formatted.charAt(i), radix);
        // Translate to that.
        translated[i] = formatTable[d];
      }
      formatted = new String(translated);
    }
    return formatted;
  }

  // Parse a string.
  public BigInteger parse(String s) {
    BigInteger big;
    // Pass it through the parse table if present.
    if (parseTable != null) {
      // Digits in the number.
      int digits = s.length();
      // Total bits (+1 to avoid sign bit).
      int bits = digits * bitsPerDigit + 1;
      // Number of bytes.
      int bytes = (bits + bitsPerByte - 1) / bitsPerByte;
      // Bias bits to slide to the right to get the bottom bit rightmost (+1 to avoid sign bit).
      int bias = (bytes * bitsPerByte) - bits + 1;
      // Make my array.
      byte[] parsed = new byte[bytes];
      // Walk the string.
      for (int i = 0, bit = bias; i < digits; i++, bit += bitsPerDigit) {
        // The character.
        char c = s.charAt(i);
        // Must be in the parse table.
        if (c < parseTable.length) {
          // Roll in each digit value into the correct bits.
          int n = parseTable[c];
          // Special cases.
          switch (n) {
            case 0:
              // Nothing to do.
              break;

            default:
              // How far to shift it to line up with "bit"
              int shift = (bitsPerByte - bitsPerDigit - (bit % bitsPerByte));
              // Sorry about the name.
              int bite = bit / bitsPerByte;
              // +ve shift is left into this byte.
              if (shift >= 0) {
                // Slide left only.
                parsed[bite] |= n << shift;
              } else {
                // Split across this byte and the next.
                parsed[bite] |= n >>> -shift;
                // Slide right.
                parsed[bite + 1] |= n << (bitsPerByte + shift);
              }
              break;

            case Invalid:
              // Must be mapped to something.
              throw new NumberFormatException("Invalid character '" + c + "' at position " + i);
          }
        } else {
          // Failed.
          throw new NumberFormatException("Invalid character '" + c + "' at position " + i);
        }
      }
      // Grow the biginteger out of the byte array.
      big = new BigInteger(parsed);
    } else {
      // No parsing - it's ordinary.
      big = new BigInteger(s, radix);
    }
    return big;
  }

  // Check a string.
  public boolean good(String s) {
    boolean good = true;
    // Check each character.
    for (int i = 0; i < s.length() && good; i++) {
      // The character.
      char c = s.charAt(i);
      if (parseTable != null) {
        if (c < parseTable.length) {
          // Must be a valid character.
          good = parseTable[c] != Invalid;
        } else {
          // Out of range of the parse table.
          good = false;
        }
      } else {
        // Use Character.digit - returns -1 if not valid.
        good = Character.digit(c, radix) != -1;
      }
    }
    return good;
  }

  public static void main(String args[]) {
    Test.main(args);
  }

}

class Test {
  // For testing only.
  private static Random r = new Random();
  /*
   * A 95 bit number fits in a 12 byte binary with a bit to spare (sign bit).
   * A 95 bit number formats in base 32 to 19 digits exactly.
   * 
   * Other numbers of this type:
   * 15 bits 2 bytes 3 digits
   * 55 bits 7 bytes 11 digits
   * 95 bits 12 bytes 19 digits
   * 135 bits 17 bytes 27 digits
   * 175 bits 22 bytes 35 digits
   * 215 bits 27 bytes 43 digits
   * 255 bits 32 bytes 51 digits
   */
  private static final int testBits = 95;

  public static void main(String args[]) {
    test(new BigInteger("10"));
    test(new BigInteger("32"));
    test(new BigInteger("100"));
    BigInteger big = BigInteger.valueOf(0);
    for (int i = 0; i < 1000; i++, big = big.add(BigInteger.ONE)) {
      test(big);
    }
    for (int i = 0; i < 1000; i++) {
      test(new BigInteger(testBits, r));
    }
    testCrockfords();
  }

  private static void test(BigInteger i) {
    test(i, Base32.ordinary, "Ordinary");
    test(i, Base32.base32Hex, "Base32Hex");
    test(i, Base32.base32, "Base32");
    test(i, Base32.crockfords, "Crockfords");
    test(i, Base32.zBase32, "ZBase32");
  }

  private static void test(BigInteger i, Base32 f, String name) {
    test(i, f, f.format(i), name);
  }

  private static void test(BigInteger i, Base32 f, String formatted, String name) {
    BigInteger parsed = f.parse(formatted);
    boolean ok = parsed.equals(i) && f.good(formatted);
        //if (!ok) {
    // For debug - so we can trace the issue.
    BigInteger reParsed = f.parse(formatted);
    boolean good = f.good(formatted);
    System.out.println(i + " = " + f.format(i) + " in " + name + (ok ? " Ok" : " BAD!"));
    if (!ok) {
      System.out.println(reParsed + " != " + i);
    }
    //}
  }

  private static void testCrockfords() {
    /// Crockford uses extras.
    BigInteger anztenney = new BigInteger("0003019140802085400304608040952");
    String formatted = Base32.crockfords.format(anztenney);
    test(anztenney, Base32.crockfords, formatted, "Crockfords Test");
    for (int i = 0; i < 100; i++) {
      BigInteger b = BigInteger.valueOf(i);
      formatted = Base32.crockfords.format(b);
      test(b, Base32.crockfords, formatted, "Crockfords Test");
    }
    for (int i = 0; i < 1000; i++) {
      BigInteger b = new BigInteger(testBits, r);
      formatted = Base32.crockfords.format(b)
              .replace('0', 'O')
              .replace('1', 'l');
      test(b, Base32.crockfords, formatted, "Crockfords Test");
    }
  }

}