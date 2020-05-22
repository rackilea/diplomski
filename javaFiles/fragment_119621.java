String extractValue(String input) {
  // check if '=' is present here...
  String[] pair = input.split("=", 2);
  String value = pair[1];
  if (value.startsWith("\"") && value.endsWith("\"")) {
      return value.substring(1, value.length() - 1);
  }
  return value;
}