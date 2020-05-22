/**
 * Parse a properly formatted String into a byte array.
 * 
 * @param in
 *          The string to parse - must be formatted
 *          "new byte[]{1,2,n}"
 * @return The byte array parsed from the input string.
 */
public static byte[] parseByteArrayFromString(
    String in) {
  in = (in != null) ? in.trim() : "";
  // Opening stanza.
  if (in.startsWith("new byte[]{")) {
    // Correct closing brace?
    if (in.endsWith("}")) {
      // substring the input.
      in = in.substring(11, in.length() - 1);
      // Create a list of Byte(s).
      List<Byte> al = new ArrayList<Byte>();
      // Tokenize the input.
      StringTokenizer st = new StringTokenizer(in,
          ",");
      while (st.hasMoreTokens()) {
        String token = st.nextToken();
        // Add a Byte.
        al.add(Byte.valueOf(token.trim()));
      }
      // Convert from the List to an Array.
      byte[] ret = new byte[al.size()];
      for (int i = 0; i < ret.length; i++) {
        ret[i] = al.get(i);
      }
      return ret;
    }
  }
  return new byte[] {};
}

public static void main(String[] args) {
  byte[] vals = parseByteArrayFromString("new byte[]{1,2,3}");
  System.out.println(Arrays.toString(vals));
}