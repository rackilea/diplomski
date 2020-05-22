public class ExpectedFailureTest {
    public class ExpectedFailure implements TestRule {
        public Statement apply(Statement base, Description description) {
            return statement(base, description);
        }

        private Statement statement(final Statement base, final Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        base.evaluate();
                    } catch (Throwable e) {
                        if (description.getAnnotation(Deprecated.class) != null) {
                            // you can do whatever you like here.
                            System.err.println("test failed, but that's ok:");
                        } else {
                            throw e;
                        }
                    }
                }
            };
        }
    }

    @Rule public ExpectedFailure expectedFailure = new ExpectedFailure();

    // actually fails, but we catch the exception and make the test pass.
    @Deprecated
    @Test public void testExpectedFailure() {
        Object o = null;
        o.equals("foo");
    }

    // fails
    @Test public void testExpectedFailure2() {
        Object o = null;
        o.equals("foo");
    }
}