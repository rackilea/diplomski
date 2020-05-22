public class BytePool {
  private class PoolObject {
    public byte[] buffer = byte[1024];
    public boolean available = false;
  }

  ArrayList<PoolObject> pool = new ArrayList<PoolObject>();

  public synchronized byte[] checkOut() {
    boolean found = false;
    for (PoolObject obj : pool) {
      if (obj.available) {
        obj.available = false;
        return obj.buffer;
      }
    }
    PoolObject newObj = new PoolObject();
    pool.add(newObj);
    return newObj.buffer;
  }

  public synchronized void checkIn(byte[] finished) {
    for (PoolObject obj : pool) {
      if (obj.buffer == finished) {
        obj.available = true;
      }
    }
  }
}