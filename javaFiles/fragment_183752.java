Config config = ;//create your own configuration object based on connections types
RedissonClient redisson = Redisson.create(config);

//The Lock is just a java.util.concurrent.locks.Lock
Lock lock = redisson.getLock("myLock");
lock.lock();

//or if you want to have a lease time on the lock
((RLock) lock).lock(10, TimeUnit.SECONDS);

//do other business here.
lock.unlock();