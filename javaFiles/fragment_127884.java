boolean isCharsetSupported(String name) {
  try {
    Charset.forName(name);
    return true;
  } catch (UnsupportedCharsetException | IllegalCharsetNameException | IllegalArgumentException e) {
    return false;
  }
}