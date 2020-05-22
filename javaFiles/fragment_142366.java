public static Foo doMyDatabaseStuff(ApplicationContext context, WebSite webSite) {
    return doMyDatabaseStuff(context, webSite, new TransactionCallback() {
        public Object doInTransaction(TransactionStatus ts) {

            //B. Do a bunch of use case specific DB stuff

            FooDao fooDao = (FooDao) context.getBean("FooDao");
            Foo foo = fooDao.create(webSite);
            {
                foo.setName("Administratoren");
                foo.setSite(webSite);
                //call a bunch of other setters
                fooDao.update(foo);

                return foo;
            }
        }
    });
}