class ThreadA {

    static Object monitor = new Object();

    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized(monitor) {
            try {
                System.out.println("Waiting for b to complete...");
                monitor.wait();
            }catch(InterruptedException e) {}
            System.out.println("Total is: " + b.total);
        }
    }
}

class ThreadB extends Thread {
    int total;
    public void run() {

        synchronized(ThreadA.monitor) {
            for (int i = 0; i < 100000000; i++) {
                total++;
            }
//            ThreadA.monitor.notify();
        }       
    }
}