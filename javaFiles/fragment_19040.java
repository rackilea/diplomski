public class MySuite extends Suite {
    // copied from Suite
    private static Class<?>[] getAnnotatedClasses(Class<?> klass) throws InitializationError {
        Suite.SuiteClasses annotation = klass.getAnnotation(Suite.SuiteClasses.class);
        if (annotation == null) {
            throw new InitializationError(String.format("class '%s' must have a SuiteClasses annotation", klass.getName()));
        }
        return annotation.value();
    }

    // copied from Suite
    public MySuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
        super(null, getRunners(getAnnotatedClasses(klass)));
    }

    public static List<Runner> getRunners(Class<?>[] classes) throws InitializationError {
        List<Runner> runners = new LinkedList<Runner>();

        for (Class<?> klazz : classes) {
            runners.add(new MyRunner(klazz));
        }

        return runners;
    }
}