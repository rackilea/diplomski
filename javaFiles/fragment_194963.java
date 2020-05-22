public class App {

    public static void main(String[] args) {
        PrintCl pcl = new PrintCl();

        Thread t1 = new Thread(new ThrdEven(pcl));
        Thread t2 = new Thread(new ThrdOdd(pcl));

        t1.start();
        t2.start();
    }
}

public class ThrdEven implements Runnable {

    private PrintCl pcl = null;

    public ThrdEven(PrintCl pcl) {
        this.pcl = pcl;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i += 2) {
            pcl.Even(i);
        }
    }
}

public class ThrdOdd implements Runnable {

    private PrintCl pcl = null;

    public ThrdOdd(PrintCl pcl) {
        this.pcl = pcl;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i += 2) {
            pcl.odd(i);
        }
    }
}

public class PrintCl {

    private final Object _lock = new Object();
    private boolean isEvenAllowed = true;

    public void Even(int n) {
        synchronized (this._lock) {
            while (!this.isEvenAllowed) {
                try {
                    this._lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    throw new RuntimeException(e);
                }
            }
            System.out.println(n);
            this.isEvenAllowed = false;
            this._lock.notifyAll();
        }
    }

    public void odd(int n) {
        synchronized (this._lock) {
            while (this.isEvenAllowed) {
                try {
                    this._lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    throw new RuntimeException(e);
                }
            }
            System.out.println(n);
            this.isEvenAllowed = true;
            this._lock.notifyAll();
        }
    }
}