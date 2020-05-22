public class TestThread implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new TestThread(), "newThread");
        thread.start();
        System.out.println(Thread.currentThread().getName() + ": 1");
        thread.run();
        System.out.println(Thread.currentThread().getName() + ": 2");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 3");
    }
}