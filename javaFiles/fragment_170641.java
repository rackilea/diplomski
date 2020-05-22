static public void assertEquals(String message, Object expected,
        Object actual) {
    if (equalsRegardingNull(expected, actual)) {
        return;
    } else if (expected instanceof String && actual instanceof String) {
        String cleanMessage = message == null ? "" : message;
        throw new ComparisonFailure(cleanMessage, (String) expected,
                (String) actual);
    } else {
        failNotEquals(message, expected, actual);
    }
}