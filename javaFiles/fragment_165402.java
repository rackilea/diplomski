public class MyResultSetInvocationHandler implements InvocationHandler {

    private final ResultSet wrappedResultSet;

    private MyResultSetInvocationHandler(ResultSet resultSet) {
        wrappedResultSet = resultSet;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try {
            // call method on delegate
            Object result = method.invoke(wrappedResultSet, args);

            // optionally do something with the result, and return it afterwards
            return result;
        }
        catch (Throwable ex) {
            // handle exception, or rethrow it
            throw ex;
        }
    }

    /**
     * Factory method, creates a dynamic proxy wrapping the given result set.
     */
    public static ResultSet wrap(ResultSet delegate) {
        MyResultSetInvocationHandler handler = new MyResultSetInvocationHandler(delegate);
        return (ResultSet) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[] { ResultSet.class }, handler);
    }
}