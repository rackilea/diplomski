private Map<Integer,Object> myMap;
private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

public void myReadMethod()
{
  rwl.readLock().lock();
  try
  {

    myMap.get(...);
    ...
  } finally
  {
    rwl.readLock().unlock();
  }
}

public void myWriteMethod()
{
  // may want / need to call rwl.readLock().unlock() here,
  // since if you are holding the readLock here already then
  // you cannot get the writeLock (so be careful on how your
  // methods lock/unlock and call each other).
  rwl.writeLock().lock();
  try
  {
    myMap.put(key1,item1);
    myMap.put(key2,item2);
  } finally
  {
    rwl.writeLock().unlock();
  }
}