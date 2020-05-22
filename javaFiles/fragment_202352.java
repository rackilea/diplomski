public class MyExceptionFactory implements ExceptionFactory{

    @Override
    public <T extends Exception> T createException(ValidationResult result, Class<T> exceptionClass, MuleEvent event) {
        return (T) createException(result, exceptionClass.getCanonicalName(), event);
    }

    @Override
    public Exception createException(ValidationResult result, String exceptionClassName, MuleEvent event) {
        //...
        //some logic to identify which kind of exception you want to throw
        //from result and event
        //...
        if(something) {
            return new SomeException("Something happened");
        } else if (somethingElse) {
            return new AnotherException("I am en error...");
        } else {
            return new BananaException("Ook");
        }
    }

}