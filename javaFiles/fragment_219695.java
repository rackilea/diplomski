public class SkipDeprecated implements TestRule {

    @Override
    public Statement apply(final Statement stmnt, final Description d) {
        if (d.getAnnotation(Deprecated.class) == null) {
            return stmnt;
        }
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                // Return an empty Statement object for those tests 
                // that shouldn't run.
            }
        };
    }
}