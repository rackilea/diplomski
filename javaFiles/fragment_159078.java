import junit.framework.TestCase;

public class __Test_AutoClosable extends TestCase {

    public void testWithNull() throws Exception {
        try (TestClosable tc = getNull()) {
            assertNull("check existance of closable", tc);
        }
    }

    public void testNonNullWithoutException() throws Exception {
        try (TestClosable tc = getNotNull(false)) {
            assertNotNull("check existance of closable", tc);
        }
    }

    public void testNonNullWithException() throws Exception {
        try (TestClosable tc = getNotNull(true)) {
            assertNotNull("check existance of closable", tc);
        }
        catch(Exception e) {
            assertEquals("check message", "Dummy Exception", e.getMessage());
        }
    }

    TestClosable getNull() {
        return null;
    }

    TestClosable getNotNull(boolean throwException) {
        return new TestClosable(throwException);
    }

    static class TestClosable implements AutoCloseable {
        private boolean throwException;
        TestClosable(boolean throwException) {
            this.throwException = throwException;
        }
        @Override
        public void close() throws Exception {
            if (throwException) {
                throw new Exception("Dummy Exception");
            }
        }
    }
}