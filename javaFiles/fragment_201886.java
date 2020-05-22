public class ErrorCodeMatcher extends BaseMatcher<Throwable> {

    private final int expectedErrorCode;

    public ErrorCodeMatcher(int expectedErrorCode) {
        this.expectedErrorCode = expectedErrorCode;
    }

    @Override
    public boolean matches(Object o) {
        return ((BusinessZipException) o).getErrorCode() == expectedErrorCode;
    }

    @Override
    public void describeTo(Description d) {
        d.appendText("Expected error code was" + expectedErrorCode);
    }
}