public static String tagDigits(String in) {
  if (in == null) {
    return "";
  }
  return in.replaceAll("\\d+", "<mo>$0</mo>");
}