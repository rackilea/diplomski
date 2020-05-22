public class PrintNumSeq extends Thread {
    static Object lock = new Object();
    static int n;
    int even;

    PrintNumSeq(int r) {
        this.even = r;
    }

    public void run() {
        try {
            synchronized (lock) {
                for (;;) {
                    while ((n & 1) != even) {
                        lock.wait();
                    }
                    n++;
                    lock.notify();
                    if (n > 10) {
                        break;
                    }
                    System.out.println(n);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PrintNumSeq(1).start();
        new PrintNumSeq(0).start();
    }
}