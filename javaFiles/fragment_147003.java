// this is from the JUnit source code 
static public void fail(String message) {
    if (message == null) {
        throw new AssertionError();
    }
    throw new AssertionError(message);
}