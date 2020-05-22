public abstract class ThreadSafeInterceptor extends AbstractInterceptor {

    public final String intercept(ActionInvocation invocation) throws Exception {

        Map<String, Object> session; // <!-- Thread Safe

        session = invocation.getInvocationContext().getSession();

        /* Do stuff */

        System.out.println(session.get("myObject"));        

        return invocation.invoke();
    }
}