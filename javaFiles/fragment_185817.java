public class FooHandler implements InvocationHandler {
    private Object realObject;

    public FooHandler (Object real) {
        realObject=real;
    }


    public Object invoke(Object target, Method method, Object[] arguments) throws Throwable {
        if ("execute".equals(method.getName()) {
            // intercept method named "execute"
        }

        // invoke the original methods
        return method.invoke(realObject, arguments);
    }
}