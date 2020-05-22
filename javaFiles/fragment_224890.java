public class FaultBarrierInterceptor {

@AroundInvoke
public Object intercept(final InvocationContext invocationContext) throws Exception {
    try {
        return invocationContext.proceed();
    } catch (final RuntimeException e) {
        final Logger logger = Logger.getLogger(invocationContext.getMethod().getDeclaringClass());
        logger.error("A fault occured during service invocation:" +
                "\n-METHOD: " + invocationContext.getMethod() +
                "\n-PARAMS: " + Arrays.toString(invocationContext.getParameters()), e);
        throw new TechnicalException();
    }
}}