public class A {
    private final Object lock;

    public A(Object lock) {
        this.lock = lock;
    }

    public void a1() { 
        synchronized(lock) {
            ...
        }
    }
}

public class B {
    private final Object lock;

    public B(Object lock) {
        this.lock = lock;
    }

    public void b1() { 
        synchronized(lock) {
            ...
        }
    }
}