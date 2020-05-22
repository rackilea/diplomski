final ReentrantLock lock = ...;
 final Condition cvar = lock.newCondition();

 ...

 lock.lock();

 try {

     while (!condition) cvar.await();
     ... do something ... 

 } finally {

     lock.unlock();
 }