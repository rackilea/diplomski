@Stateless
public class TransactionService {

   @TransactionAttribute(REQUIRES_NEW)
   public Object executeTransaction(final Callable<Object> task) {
       return task.call();
   }
}

@Interceptor
public class MyInterceptor {

  @EJB
  private TransactionService service;

   @AroundInvoke
    public Object logMethodEntry(InvocationContext ctx) throws Exception {
        Object proceed = null;
        try {
            proceed = service.executeTransactional(()->ctx.proceed());
            //If you reach here, you will be guaranteed of commit and then you can do the elastic search update
            return proceed;
        } catch (Exception e) {
            //If this happens, and you propagate it, then for sure the transaction will be rolledback, and never get committed. Since all db calls were being done within this transaction, then no DB commit will be done.
            throw e;
        }
    }
}