// you need volatile, because of JVM thread caching
private static volatile MyCache instance;

private MyCache() {}

public static MyCache getInstance() {
    if (instance == null) {
        synchronize(MyCache.class) {
            // yes, you need double check, because of threads
            if (instance == null) {
                instance = new MyCache();
            }
        }
    }
    return instance;
}