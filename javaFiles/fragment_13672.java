public class MyCache { 

    private Map<MyKey, Object> cache = new HashMap<MyKey, Object>();

    public Object getObject(Object key1, Object key2){
        return cache.get(new MyKey(key1, key2));
    }
    public void putObject(Object key1, Object key2, Object value){
        cache.put(new MyKey(key1, key2), value);
    }
}