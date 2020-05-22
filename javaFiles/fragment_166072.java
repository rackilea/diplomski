public class SomeClass {
    public static void someMethod() {
        synchronized (SomeClass.class) {
            // critical section
        }
    }
}