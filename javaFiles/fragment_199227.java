public class ProxyWeakReference<K> extends WeakReference<K>{
    public ProxyWeakReference(K o, ReferenceQueue<K> q)
    {
        super(o,q);
    }
}

public class SafeQueueMap<K,V>{
    ConcurrentMap<WeakReference<K>,V> d=new ConcurrentHashMap<WeakReference<K>, V>();
    ReferenceQueue<K> refQueue=new ReferenceQueue<K>();

    public void put(K k ,V v){
        WeakReference<K> r=new ProxyWeakReference<K>(k,refQueue);
        d.put((ProxyWeakReference<K>) r,v);
    }
}