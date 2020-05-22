public class MyMainClass {
    @Inject
    MyMainClass(Provider<MyRunnable> runnableProvider) { ... }

    public void spawnThread() {
        new Thread(runnableProvider.get()).start();
    }
}

public class MyRunnable implements Runnable {
    @Inject
    MyRunnable(ClassX myX) { ... }
    public void run() {
        ... do work ...
    }
}