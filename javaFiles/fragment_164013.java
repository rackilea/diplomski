private final Object LOCK = new Object();
synchronized(LOCK){
  LOCK.wait();
}
synchronized(LOCK){
  LOCK.notify();
}