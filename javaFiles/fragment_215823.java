public void await() {
    lock.lock();
    try {
      condition.await();
    } catch(Exception e) {}
    finally{
      lock.unlock();
    }
  }