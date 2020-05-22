public final class Singleton {
    private final static Singleton ourInstance = new Singleton();
    public static Singleton getInstance() {
        return ourInstance;
    }

    // Contructor is private, so it won't be possible 
    // to create instance of this class from outside of it.
    private Singleton() {
    }
}