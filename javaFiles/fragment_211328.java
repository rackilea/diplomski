private Optional<String> regexIsValid(String regex) {
  try {
    Pattern pattern = Pattern.compile(regex);
    return Optional.empty();
  } catch (PatternSyntaxException e) {
    return Optional.of(e.getMessge());
  }
}