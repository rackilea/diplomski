public class Foo {
    // instance method with synchronized modifier
    public synchronized void foo3() {
        // ...
    }
    // equivalent synchronized statement
    public void foo4() {
        synchronized (this) {
            // ...
        }
    }
}