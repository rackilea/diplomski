//original, unmodifiable 3rdParty code, here as a example
public String getAnswer() {
    try {
        //some code
        throw new SomeException("a message");
    } catch (final SomeException e) {
        return null;
    }
}

//a wrapper to getAnswer to unwrapp the `SomeException`
public String getAnswerWrapped() throws SomeException {
    try {
        return getAnswer();
    } catch (final SomeExceptionWrapperException e) {
        throw (SomeException) e.getCause();
    }
}

@Test(expected = SomeException.class)
public void testThrow() throws SomeException {
    final String t = getAnswerWrapped();
}