public class GlobalMap extends SimpleBindings implements Closeable {

    private final static String NASHORN_GLOBAL = "nashorn.global";
    private Bindings global;
    private Set<String> original_keys;

    public GlobalMap(Map<String, Object> map) {
        super(map);
    }

    @Override
    public Object put(String key, Object value) {
        if (key.equals(NASHORN_GLOBAL) && value instanceof Bindings) {
            global = (Bindings) value;
            original_keys = new HashSet<>(global.keySet());
            return null;
        }
        return super.put(key, value);
    }

    @Override
    public Object get(Object key) {
        return key.equals(NASHORN_GLOBAL) ? global : super.get(key);
    }

    @Override
    public void close() {
        if (global != null) {
            Set<String> keys = new HashSet<>(global.keySet());
            keys.removeAll(original_keys);
            for (String key : keys)
                put(key, global.remove(key));
        }
    }
}