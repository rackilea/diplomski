public class MyRunnable implements Runnable {
    public void run() {
        mycomputation();
    }
}
new Thread(new MyRunnable()).start();