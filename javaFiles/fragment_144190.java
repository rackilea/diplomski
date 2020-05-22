public class SoTest {
    public class ExceptionLoggingRule implements TestRule {
        public Statement apply(Statement base, Description description) {
            return statement(base);
        }

        private Statement statement(final Statement base) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        base.evaluate();
                    } catch (Exception e) {
                        System.out.println("caught an exception");
                        e.printStackTrace(System.out);
                        throw e;
                    }
                }
            };
        }
    }

    @Rule public ExceptionLoggingRule exceptionLoggingRule = new ExceptionLoggingRule();
    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testMe() throws Exception {
        expectedException.expect(IOException.class);
        throw new IOException("here we are");
    }
}