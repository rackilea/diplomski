public static int parseInteger( String string, int defaultValue ) {
  try {
    return Integer.parseInt(string);
  }
  catch (NumberFormatException e ) {
    return defaultValue;
  }
}