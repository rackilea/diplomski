class PrepareFile implements org.junit.rules.TestRule {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface FileName {
        String value() default "";
    }

    @Override
    public Statement apply(final Statement statement, final Description description) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                String fileName = description.getAnnotation(FileName.class).value();
                File file = new File(fileName);
                try { 
                    file.createNewFile();
                    statement.evaluate();
                } finally {
                    file.delete();
                }
            }
        };
    }
}