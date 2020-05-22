class DataObject {

  private static final Object cacheLock = new Object();

  public putInCache() {
    synchronized(cacheLock) {

      // ... do some stuff
      cache.insert(this);
      // ... do some more stuff

    }
  }
}