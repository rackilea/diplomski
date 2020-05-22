public class Base {
    public static void printBase() {
        synchronized (Base.class) {
            System.out.println("Inside Base");
        }
    }
}

public class Derived extends Base {
    public static void printDerived() {
        synchronized (Derived.class) {
            System.out.println("Inside Derived");
        }
    }
}