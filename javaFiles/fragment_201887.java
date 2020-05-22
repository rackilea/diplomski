public class ErrorCodeMatcher<T extends Exception & ErrorAwareException> extends TypeSafeMatcher<T> {

    public static <E extends Exception & ErrorAwareException> ErrorCodeMatcher<E> exceptionWithErrorCode(final int expectedErrorCode) {
        return new ErrorCodeMatcher<E>(expectedErrorCode);
    }
    private final int expectedErrorCode;

    public ErrorCodeMatcher(int expectedErrorCode) {
        this.expectedErrorCode = expectedErrorCode;
    }

    @Override
    protected boolean matchesSafely(final T t) {
        return t.getErrorCode() == expectedErrorCode;
    }

    @Override
    public void describeTo(Description d) {
        d.appendText("Expected error code was" + expectedErrorCode);
    }
}