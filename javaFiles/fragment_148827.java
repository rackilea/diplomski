public class CommercialObjectFactory extends BasePoolableObjectFactory { 
    // for makeObject we'll simply return a new commercial object
    @Override
    public Object makeObject() { 
        return new CommercialObject(); 
    } 
}

GenericObjectPool pool = new GenericObjectPool(new CommercialObjectFactory());

// The size of pool in our case it is N
pool.setMaxActive(N) 
// We want to wait if the pool is exhausted
pool.setWhenExhaustedAction(GenericObjectPool.WHEN_EXHAUSTED_BLOCK)