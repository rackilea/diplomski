public class Singleton {
    private static final Singleton instance = new Singleton();

    // Private constructor prevents instantiation from other classes
    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}