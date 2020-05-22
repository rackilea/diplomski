public final class Foo extends Cucumber {
    static Runtime runtime;

    /**
     * Constructor called by JUnit.
     *
     * @param clazz the class with the @RunWith annotation.
     * @throws IOException         if there is a problem
     * @throws InitializationError if there is another problem
     */
    public Foo(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }

    @Override
    protected Runtime createRuntime(ResourceLoader resourceLoader, ClassLoader classLoader, RuntimeOptions runtimeOptions) throws InitializationError, IOException {
        runtime = super.createRuntime(resourceLoader, classLoader, runtimeOptions);
        return runtime;
    }
}