@Interceptor
@TransactionDebugger
public class TransactionInterceptor {
    private Logger logger = LogManager.getLogger();

    @AroundInvoke
    public Object runInTransaction(InvocationContext invocationContext) throws Exception {
        Object result = null;
        try {
            result = invocationContext.proceed();
        } catch (Exception e) {
            logger.error("Error encountered during Transaction.", e);
            throw e;
        }
        return result;
    }
}