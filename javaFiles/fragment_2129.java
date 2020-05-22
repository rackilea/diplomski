public class Example {
    private final Object lock = new Object();

    // does not compile, there is no 'this' in static context.
    public static void staticMethod() {
        synchronized (this) {
        }
    }

    public void method() {
        int x = 3;
        //there is risk that someone else outside our code
        //uses same lock
        synchronized (this) {

        }
        //this lock is private
        synchronized (lock) {
        }
    }
}