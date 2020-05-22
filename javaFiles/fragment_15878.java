public class ResponseCache {
    private static final ResponseCache myInstance = new ResponseCache();

    private final Map<String, Response> cacheStore = new HashMap<>();

    private ResponseCache() {
    }

    public static ResponseCache getInstance() {
        return myInstance;
    }

    public void addResponse(String key, Response value) {
        cacheStore.put(key, value);
    }

    public boolean exists(String key) {
        return cacheStore.containsKey(key);
    }

    public void remove(String key) {
        if (exists(key)) {
            cacheStore.remove(key);
        }
    }

    public Response get(String key) {
        return exists(key) ? cacheStore.get(key) : null;
    }

}