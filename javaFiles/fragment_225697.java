public final class Singleton {
    // Thread-safe due to guarantees about initializers
    private static final Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}