static class NiceCharacter {
  // The actual character.
  final char ch;

  public NiceCharacter ( char ch ) {
    this.ch = ch;
  }

  @Override
  public String toString () {
    return stringValue(ch);
  }

  public static String stringValue ( char ch ) {
    switch ( Character.getType(ch)) {
      // See http://en.wikipedia.org/wiki/Mapping_of_Unicode_characters for what the Cc group is.
      // See http://en.wikipedia.org/wiki/Control_character for a definition of what  are CONTROL characters.
      case Character.CONTROL:
        return Integer.toString(ch);

      default:
        return Character.toString(ch);
    }
  }
}