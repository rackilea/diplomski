// private constructor, public static instance
// usage: Blah.INSTANCE.someMethod();
public class Blah {
    public static final Blah INSTANCE = new Blah();
    private Blah() {
    }
    // public methods
}

// private constructor, public instance method
// usage: Woo.getInstance().someMethod();
public class Woo {
    private static final Woo INSTANCE = new Woo();
    private Woo() {
    }
    public static Woo getInstance() {
        return INSTANCE;
    }
    // public methods
}

// Java5+ single element enumeration (preferred approach)
// usage: Zing.INSTANCE.someMethod();
public enum Zing {
    INSTANCE;
    // public methods
}