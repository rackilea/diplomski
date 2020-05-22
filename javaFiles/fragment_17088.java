public class ConstructorParameterRequest extends Request {

    private Class<?> clazz;
    private Object[] parameters;

    public ConstructorParameterRequest(Class<?> clazz, Object[] parameters) {
        this.clazz = clazz;
        this.parameters = parameters;
    }

    @Override
    public Runner getRunner() {
        try {
            return new ConstructorParameterRunner(clazz, parameters);
        } catch (Throwable e) {
            return new ErrorReportingRunner(clazz, e);
        }
    }

}