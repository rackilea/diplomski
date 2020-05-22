import java.util.concurrent.Semaphore;

class A extends Thread {

    private int i;
    public A(int x) {
        i = x;
    }

    public void run() {
       System.out.println(i);
    }

    public static void main(String[] args) throws Exception {
        A thread1 = new A(5);
        A thread2 = new A(6);
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
    }
}