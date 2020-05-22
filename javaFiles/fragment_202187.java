public class CHILD_THREAD extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("CHILD_THREAD_INTERRUPTED");
                return;
            }
            System.out.println("I'AM A LAZY THREAD");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("CHILD_THREAD_INTERRUPTED");
                return;
            }
        }
    }
}