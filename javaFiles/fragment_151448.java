public class Singleton {

private static Singleton unique = null;

private Singleton() {
}

public static synchronized Singleton getInstance() {
    if (unique == null) {
        unique = new Singleton();
    }
    return unique;
}
}