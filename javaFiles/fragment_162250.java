@MySecurityInterceptorBinding
public class MySecurityInterceptor {
    @Inject HttpServletRequest request;

    @AroundInvoke
    public Object secure(InvocationContext ctx) {
        // check security
        if( request.isUserInRole("foo") ) {
            Object value = ctx.proceed();
            // modify the returned value
            ((MyCustomResponseBase) value).setSecurityPassedFlag(true);
            return value;
            // or change it altogether (I'm not sure if this is entirely possible, try and see :)
            MyResponseValueWrapper w = new MyResponseValueWrapper(value);
            w.setXxxx("yyyy");
            return w;
        }
        else {
            // handle it...
        }
    }