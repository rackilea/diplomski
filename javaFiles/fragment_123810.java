public class Consumer implements Runnable {

    private SharedData sharedData;

    public Consumer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 10; i++) {

            Calc result = this.sharedData.calc();
            System.out.println(result);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

public class Producer implements Runnable {

    private SharedData sharedData;

    private Random numGenerator = new Random();

    public Producer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 10; i++) {
            double firstNum = numGenerator.nextDouble();
            double secondNum = numGenerator.nextDouble();

            this.sharedData.store(firstNum, secondNum);
            //System.out.println("Sum: " + firstNum + ", " + secondNum);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}

public class Calc {

    final double x;
    final double y;
    final double r;

    public Calc(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public String toString() {
        return x + "," + y + "=" + r;
    }
}

public class SharedData {

    private double x = 0;
    private double y = 0;

    private volatile boolean empty = true;

    public synchronized Calc calc() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        // Create my Calc before the data can be changed.
        Calc calc = new Calc(x, y, (x + y) / 2);
        empty = true;
        notifyAll();
        return calc;
    }

    public synchronized void store(double x, double y) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        // Toggle status.
        empty = false;
        this.x = x;
        this.y = y;
        notifyAll();
    }

}

public void test() throws InterruptedException {
    System.out.println("Hello");
    SharedData data = new SharedData();
    Thread pThread = new Thread(new Producer(data));
    Thread cThread = new Thread(new Consumer(data));
    pThread.start();
    cThread.start();
    pThread.join();
    cThread.join();
}