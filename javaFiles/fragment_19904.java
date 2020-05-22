public class MyThread extends Thread {
private static int j = 0;

public void run() {
    synchronized(this) {
        for (int i = 1; i <= 10; i++) {
            j += i;
        }
    }
    System.out.println(j);
}