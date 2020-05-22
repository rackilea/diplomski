@Around("@annotation(framework.db.MultiDbTransactional)")
public Object multiDbTransaction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

    // Get class and method, needed for parent invocation. We need to cast to the actual
    // implementation
    MethodInvocationProceedingJoinPoint mipJoinPoint = (MethodInvocationProceedingJoinPoint) proceedingJoinPoint;
    MethodSignature signature = (MethodSignature) mipJoinPoint.getSignature();
    Class<?> clazz = mipJoinPoint.getTarget().getClass();
    Method method = signature.getMethod();

    return invokeWithinTransaction(method, clazz, new InvocationCallback() {
        @Override
        public Object proceedWithInvocation() throws Throwable {

            // This class will create the other transactions, not of interest here.
            MultiDbTxnContext ctx = new MultiDbTxnContext();
            ctx.startTransactions();

            /*
             * We have started the transactions, so do the job. We mimic DEFAULT spring behavior
             * regarding exceptions, so runtime exceptions roll back, the rest commits.
             */
            try {
                Object result = proceedingJoinPoint.proceed();
                ctx.finishTransactions();
                return result;
            } catch (Error | RuntimeException re) {
                ctx.rollbackTransactions();
                throw re;
            } catch (Throwable t) {
                ctx.commitTransactions();
                throw t;
            }
        }
    });

}