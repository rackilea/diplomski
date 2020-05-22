/**
 * Asserts that two objects are equal. If they are not
 * an AssertionFailedError is thrown with the given message.
 */
static public void assertEquals(String message, Object expected, Object actual) {
    if (expected == null && actual == null) {
        return;
    }
    if (expected != null && expected.equals(actual)) {
        return;
    }
    failNotEquals(message, expected, actual);
}