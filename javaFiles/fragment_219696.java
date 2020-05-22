public class SkipDeprecated implements TestRule {

    @Override
    public Statement apply(final Statement stmnt, final Description d) {
        if (d.getAnnotation(Deprecated.class) == null) {
            return stmnt;
        }
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                throw new AssumptionViolatedException("Test is deprecated.");
            }
        };
    }
}