// similar to UDF, but not generic to make it easier to understand
interface Callback {
    void call(String message);
}

class Registry {
    private Map<String, Callback> callbacks = new HashMap<>();

    public registerCallback(String name, Callback callback) {
        callbacks.put(name, callback;
    }

    public void invokeCallback(String name, String message) {
        Callback cb = map.get(name);
        cb.call(message);
    }
}