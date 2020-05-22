private static Foo doMyDatabaseStuff(ApplicationContext context, WebSite webSite, TransactionCallback cb) {

    //A. Do a bunch of boilerplate Transaction stuff

    TransactionUtils transactionUtils = getTransactionUtils(context);

    return (Foo) transactionUtils.execute(cb);
}