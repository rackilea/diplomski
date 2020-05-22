public class Foo {
    private final  Lock lock  = new ReentrantLock();
    public void bar() throws InterruptedException {
        lock.lockInterruptibly();
        try {
          // Do stuff
        }finally {
           lock.unlock()
        }
    }
}