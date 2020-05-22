private static String stripHelloFromEnd(String input) {
  if (input.endsWith("hello")) {
    return input.substring(0, input.length() - "hello".length());
  }
  return input;
}