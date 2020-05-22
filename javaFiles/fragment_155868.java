public class ObjectPool<T> {
    private ConcurrentMap<T, T> map = new ConcurrentHashMap<>();

    public T get(T object) {
        T old = map.putIfAbsent( object, object );
        return old == null ? object : old;
    }
}