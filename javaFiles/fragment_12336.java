public class MySingleton {
    private static MySingleton instance = new MySingleton();

    private volatile int next = 0;

    private MySingleton() {
        // prevent external instantiation of a singleton.
    }

    public static MySingleton getInstance() {
        return instance;
    }

    public synchronized int getNextSequence() {
        return next++;
    }
}