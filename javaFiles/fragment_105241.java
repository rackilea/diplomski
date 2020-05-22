class Print {

    private static int count = 1;
    private static int MAX = 20;
    private boolean isOdd = true;

    public void printEven() {
        while (true) {
            if (count > MAX) break;
            if (!isOdd) {
                System.err.println(Thread.currentThread().getName() + ":" + count++);
                isOdd = true;
            }
        }
    }

    public void printOdd() {
        while (true) {
            if (count > MAX) break;
            if (isOdd) {
                System.err.println(Thread.currentThread().getName() + ":" + count++);
                isOdd = false;
            }
        }
    }

}

public class ThreadOddEven {
    public static void main(String[] args) {
        Print p = new Print();

        // Thread t1 = new Thread(() -> p.printEven());
        Thread t1 = new Thread(new Runnable() {     
           @Override
           public void run() {
              p.printEven();                
           }
        });
        t1.setName("EVEN");

        // Thread t2 = new Thread(() -> p.printOdd());
        Thread t2 = new Thread(new Runnable() {
           @Override
           public void run() {
              p.printOdd(); 
           }
        });
        t2.setName("ODD");

        t1.start();
        t2.start();
    }

}