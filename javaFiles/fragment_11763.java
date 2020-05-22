Lock lock = new ReentrantLock();
assertEquals(0, lock.getHoldCount());
boolean b1 = lock.tryLock();
System.out.println(b1); //prints true       
assertEquals(1, lock.getHoldCount());
boolean b2 = lock.tryLock();
System.out.println(b2); //prints true again
assertEquals(2, lock.getHoldCount());