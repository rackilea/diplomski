public class CacheEntryEventFilterImpl implements CacheEntryEventFilter<Integer, MyDomain> {
    @Override
    public boolean evaluate(CacheEntryEvent<? extends Integer, ? extends MyDomain> event)
            throws CacheEntryListenerException {
        return doSomething();
    }
}


public class FactoryImpl implements Factory<CacheEntryEventFilter<Integer, MyDomain>> {
    private static final long serialVersionUID = 881669537085864136L;

    @Override
    public CacheEntryEventFilter<Integer, MyDomain> create() {
        return new CacheEntryEventFilterImpl();
    }
}