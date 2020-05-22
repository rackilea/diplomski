void doSomething(K key) {
     myMap.putIfAbsent(key, new Semaphore(1));
     Semaphore s = myMap.get(myKey);
     s.aquire();
     try {
     // do stuff
     } finally {
       s.release();
     }
 }