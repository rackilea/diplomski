public class Foo {

    private long threadCount;

    public synchronized void enter() {
        threadCount++;
    }

    public synchronized void exit() {
        threadCount--;
        notifyAll();
    }

    public synchronized void doStuff() {
        ...
    }

    public synchronized void logout() {
        while(threadCount > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                ...
            }
        }
    }

}