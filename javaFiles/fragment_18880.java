lock.lock();

 try {

     ... do something ...
     cvar.signalAll();

 } finally {

     lock.unlock();
 }