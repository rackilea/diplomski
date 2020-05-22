class PrintDemo implements Runnable {
    @Override
    public synchronized void run() {
        for(int i = 5; i > 0; i--) {
            System.out.println("Counter   ---   "  + i );
        }
    }
}

class Main {
    public static void main(String[] args) {
        PrintDemo pd = new PrintDemo();

        Thread t1 = new Thread(pd);
        Thread t2 = new Thread(pd);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch(InterruptedException ie) {
            System.err.println(ie);
        }
    }
}