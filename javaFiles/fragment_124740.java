ThreadLocal<Object> alreadyIn = new ThreadLocal<>();
public void someMethod() {
  boolean needSem = (alreadyIn.get() == null);
  if(needSem) {
    semaphore.acquire();
    alreadyIn.set(new Object());
  }
  try {
    // do stuff
  } finally {
    if(needSem) {
      alreadyIn.remove();
      semaphore.release();
    }
  }
}