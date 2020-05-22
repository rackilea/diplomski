private boolean regexIsValid(String regex) {
  try {
    return Pattern.compile(regex) != null;
  } catch (PatternSyntaxException e) {
    return false;
  }
}