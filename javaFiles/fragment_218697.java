class NotPrimeRunnable implements Runnable {
    private ThreadDemo threadDemo;
    int number = 0;

    public NotPrimeRunnable(ThreadDemo threadDemo) {
        this.threadDemo = threadDemo;
    }

    public void run() {
        threadDemo.prime(number);
    }
}

class PrimeRunnable implements Runnable {

    private ThreadDemo threadDemo;

    public PrimeRunnable(ThreadDemo threadDemo) {
        this.threadDemo = threadDemo;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 20; i++) {
            if (threadDemo.prime(i)) {
                System.out.printf("Prime No.= %d \n", i);
            }
        }
    }

}

class ThreadDemo {
    public synchronized boolean prime(int start_value) {
        for (int i = 2; i < start_value; i++) {
            if (start_value % i == 0) {
                System.err.printf("No. Prime = %d \n", start_value);
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        ThreadDemo runnableTask = new ThreadDemo();
        PrimeRunnable th1 = new PrimeRunnable(runnableTask);
        Thread childOne = new Thread(th1);
        childOne.start();
        NotPrimeRunnable th2 = new NotPrimeRunnable(runnableTask);
        Thread childTwo = new Thread(th2);
        childTwo.start();
    }
}