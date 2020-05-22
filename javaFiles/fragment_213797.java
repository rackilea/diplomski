public class MySingleton {

    private MySingleton INSTANCE;

    // private constructor is best practice for a singleton 
    private MySingleton(File theFile) {
        // initialize class using "theFile"
    }

    public static void init(File theFile) {
        // if init previously called, throw IllegalStateException
        if (INSTANCE != null)
            throw new IllegalStateException();
        // initialize singleton 
        INSTANCE = new MySingleton(theFile);
    }

    public static MySingleton getInstance() {
        // if init hasn't been called yet, throw IllegalStateException
        if (INSTANCE == null)
            throw new IllegalStateException();
        return INSTANCE;
    }

    // rest of class
}