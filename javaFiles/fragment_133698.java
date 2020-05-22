private int counter1;
private int counter2;
private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
private final Lock r = rwl.readLock();
private final Lock w = rwl.writeLock();

public void method1(){
   r.lock();
   try { 
     if (counter1>0) {
        ...........do something
     if (counter2>0) {
        ....do something else
     }
   } finally { r.unlock(); }

}

public void method2() {
  w.lock();
  try { 
    counter1=0;
    counter2=0; 
  } finally { w.unlock(); }

}