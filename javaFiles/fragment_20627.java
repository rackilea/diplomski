class Pool {
  private static final int MAX_AVAILABLE = 100;
  private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

  public Object getItem() throws InterruptedException {
   available.acquire();
   return getNextAvailableItem();
  }

  public void putItem(Object x) {
   if (markAsUnused(x))
    available.release();
  }