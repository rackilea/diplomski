package com.apple.paymentgateway.communicator;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class Test {

    public void initializePool() throws Exception {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();

        // parameters for the life cycle of the objects
        config.setMinIdle(1);
        config.setMaxIdle(1);
        config.setMaxTotal(1);

        // if the object is not accessed in 5 minutes, it evicted (throw away from the pool)
        config.setTimeBetweenEvictionRunsMillis(5 * 60 * 1000);
        // frequency at which it check for objects to be evicted
        config.setMinEvictableIdleTimeMillis(1 * 60 * 1000);

        CommonsObjectPool pool = new CommonsObjectPool(new MyObjectPoolFactory(), config);

        MyObject myObj = pool.borrowObject(); //borrow an object
    }

    /**
     * An object pool implementation of your objects
     */
    class CommonsObjectPool extends GenericObjectPool<MyObject> {

        public CommonsObjectPool(PooledObjectFactory<MyObject> factory) {
            super(factory);
        }

        public CommonsObjectPool(PooledObjectFactory<MyObject> factory, GenericObjectPoolConfig config) {
            super(factory, config);
        }
    }



    /**
     * Factory to create the objects
     */
    class MyObjectPoolFactory extends BasePooledObjectFactory<MyObject> {
        @Override
        public MyObject create() throws Exception {
            // create your object
            return new MyObject();
        }

        @Override
        public PooledObject<MyObject> wrap(MyObject arg0) {
            return new DefaultPooledObject<MyObject>(arg0);
        }

        @Override
        public boolean validateObject(PooledObject<MyObject> pooledObj) {
            return pooledObj.getObject().isMyObjectValid(); // implement a validation
        }

        @Override
        public void destroyObject(PooledObject<MyObject> pooledObj) throws Exception {
            // clean up the object
            //pooledObj.getObject().close ()
        }
    }   

    class MyObject {
        public boolean isMyObjectValid() {
            return true;
        }

        public void close () {
         // clean up the object
        }
    }
}