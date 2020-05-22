static public void fail(String message, Throwable t) {
    if (message == null) {
        throw new AssertionError(t);
    }
    throw new AssertionError(message, t);
}