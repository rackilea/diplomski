public class PrintThread implements Runnable {
    static int number = 1;
    public PrintThread() {
        Thread t1 = new Thread(this, "1");
        Thread t2 = new Thread(this, "2");
        Thread t3 = new Thread(this, "3");
        Thread t4 = new Thread(this, "4");
        Thread t5 = new Thread(this, "5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        print();
        System.out.println(" thread EXIT " + Thread.currentThread().getName());
    }

    synchronized static int getNumber() {
        return number;
    }

    synchronized static void incNumber() {
        number++;
    }

    synchronized public void print() {
        while (Integer.parseInt(Thread.currentThread().getName()) != number) {
            try {
                System.out.println(" Waiting thread  " + Thread.currentThread().getName());
                wait();
                System.out.println(" resumed thread started " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (Integer.parseInt(Thread.currentThread().getName()) == number) {
            System.out.println(" thread started " + Thread.currentThread().getName());
            incNumber();
            notifyAll();
        }
    }

    public static void main(String[] args) {
        new PrintThread();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread main exit");
    }
}