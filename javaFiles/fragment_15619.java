public abstract class ThreadUnsafeInterceptor extends AbstractInterceptor {

    private Map<String, Object> session; // <!-- Thread Unsafe

    public final String intercept(ActionInvocation invocation) throws Exception {
        session = invocation.getInvocationContext().getSession();       
        /* Do stuff */

        System.out.println(session.get("myObject"));        

        return invocation.invoke();
    }
}