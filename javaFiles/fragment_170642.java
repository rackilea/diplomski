static public void assertNotEquals(String message, Object unexpected,
    Object actual) {
  if (equalsRegardingNull(unexpected, actual)) {
      failEquals(message, actual);
  }
}

private static void failEquals(String message, Object actual) {
  String formatted = "Values should be different. ";
  if (message != null) {
      formatted = message + ". ";
  }

  formatted += "Actual: " + actual;
  fail(formatted);
}