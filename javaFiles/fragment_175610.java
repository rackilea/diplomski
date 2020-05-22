boolean customParseBoolean(String input) {
  if ("t".equals(input)) {
    return true;
  } else if ("f".equals(input)) {
    return false;
  }
  // You don't have to throw an exception on invalid input; just an example.
  throw new IllegalArgumentException("Invalid input: " + input);
}