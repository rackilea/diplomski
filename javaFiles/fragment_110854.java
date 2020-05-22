public abstract class MyApplicationException<T> extends Exception {
    private T faultBean;

    // Constructors, setters/getters
}

@Provider
public class MyApplicationExceptionHandler implements ExceptionMapper<MyApplicationException<?>> {
    // Implementation
}