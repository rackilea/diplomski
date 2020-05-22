@AroundInvoke
public Object logMethodEntry(InvocationContext ctx) throws Exception {
    Object proceed = null;
    try {
        proceed = ctx.proceed();
        // is the transacction finished/commited already?
        // The transaction is successful, but afaik, it is not yet committed, until this method returns successfully
        // is it still open ? More or less. You can still grab the Ejbtransaction and commit it manually or rollback if some other conditions have not been met yet
        return proceed;
    } catch (Exception e) {
        //If this happens, and you propagate it, then for sure the transaction will be rolledback, and never get committed. Since all db calls were being done within this transaction, then no DB commit will be done.
        throw e;
    }
}