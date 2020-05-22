public abstract class Cache<K, V>
{

  private final ConcurrentMap<K, Future<V>> cache = new ConcurrentHashMap<>();

  public final V get(K key)
    throws InterruptedException, ExecutionException
  {
    Future<V> ref = cache.get(key);
    if (ref == null) {
      FutureTask<V> task = new FutureTask<>(new Factory(key));
      ref = cache.putIfAbsent(key, task);
      if (ref == null) {
        task.run();
        ref = task;
      }
    }
    return ref.get();
  }

  protected abstract V create(K key)
    throws Exception;

  private final class Factory
    implements Callable<V>
  {

    private final K key;

    Factory(K key)
    {
      this.key = key;
    }

    @Override
    public V call()
      throws Exception
    {
      return create(key);
    }

  }

}