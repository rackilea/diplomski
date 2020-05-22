public class WaitCursorInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // show the cursor
        MainUI.getInstance().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        // execute the method annotated with `@WaitCursor`
        Object result = invocation.proceed();
        // hide the waiting cursor
        MainUI.getInstance().setCursor(Cursor.getDefaultCursor());
        return result;
    }
}