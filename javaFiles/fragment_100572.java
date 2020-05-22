new NonStrictExpectations(mCurrencyDao) {
    {
        invoke(mCurrencyDao, "readSqlQuery", withAny(String.class));
        result = new Delegate<String>() {
            @SuppressWarnings("unused")
            String delegate(Invocation invocation) {
                if (invocation.getInvocationIndex() == 0) {
                    return prepareTestSQL(pAllKeysForTest);
                } else {
                    return invocation.proceed();
                }
            }
        };
        times = 2;
    }
};
mCurrencyDao.loadAll(lToday);
mCurrencyDao.loadAll(lTomorrow);