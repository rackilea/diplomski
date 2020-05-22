public class ConstructorParameterRunner extends BlockJUnit4ClassRunner {

    private Object[] parameters;

    public ConstructorParameterRunner(Class<?> clazz, Object[] parameters) throws InitializationError  {
        super(clazz);
        this.parameters = parameters;
    }

    @Override
    protected void validateConstructor(List<Throwable> errors) {
        validateOnlyOneConstructor(errors);
    }

    @Override
    protected Object createTest() throws Exception {
        return getTestClass().getOnlyConstructor().newInstance(parameters);
    }

}