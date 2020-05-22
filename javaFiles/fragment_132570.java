public final class DemoRunnable implements Runnable {
    @Override
    public synchronized void run() {
        System.out.println("Started");
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new DemoRunnable();
        Thread a = new Thread(runnable, "A");
        Thread b = new Thread(runnable, "B");
        a.start();
        b.start();
    }
}