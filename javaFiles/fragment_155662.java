private final ThreadLocal<Map<String, Object>> holder = new ThreadLocal<Map<String, Object>>();

...

@Override
public Object get(String name, ObjectFactory<?> objectFactory) {
    Map<String, Object> cache = this.holder.get();
    if (cache == null) {
        cache = new HashMap<String, Object>();
        this.holder.set(cache);
    }
    Object object = cache.get(name);
    if (object == null) {
        object = objectFactory.getObject();
        cache.put(name, object);
    }
    return object;
}

public void clearCache() {
    this.holder.remove();
}