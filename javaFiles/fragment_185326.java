public class Letters {
public static void main(String[] args) {

    char[] arr1 = new char[] { 'A', 'E', 'I', 'M', 'Q', 'U', 'Y' };
    char[] arr2 = new char[] { 'B', 'F', 'J', 'N', 'R', 'V', 'Z' };
    char[] arr3 = new char[] { 'C', 'G', 'K', 'O', 'S', 'W' };
    char[] arr4 = new char[] { 'D', 'H', 'L', 'P', 'T', 'X' };

    TSync sync1 = new TSync();
    TSync sync2 = new TSync();
    TSync sync3 = new TSync();
    TSync sync4 = new TSync();

    Mythread c1 = new Mythread(arr1, sync1, sync2);
    Mythread c2 = new Mythread(arr2, sync2, sync3);
    Mythread c3 = new Mythread(arr3, sync3, sync4);
    Mythread c4 = new Mythread(arr4, sync4, sync1);

    Thread t1 = new Thread(c1);
    Thread t2 = new Thread(c2);
    Thread t3 = new Thread(c3);
    Thread t4 = new Thread(c4);

    t1.start();
    t2.start();
    t3.start();
    t4.start();

    System.out.println("Signalling Thread 1 is ready to work");
    sync1.signalNextThread();

}
}

class Mythread extends Thread {
private final char[] arr;
private final TSync waitOnSync;
private final TSync signalSync;

public Mythread(char[] arr, TSync waitOnSync, TSync signalSync) {
    super();
    this.arr = arr;
    this.waitOnSync = waitOnSync;
    this.signalSync = signalSync;
}

@Override
public void run() {
    boolean isInterrupted = false;
    for (int i=0; i<arr.length && !isInterrupted; i++) {
        try {
            waitOnSync.waitForPreviousThread();
            System.out.println(arr[i]);
            signalSync.signalNextThread();
        } catch (InterruptedException e) {
            isInterrupted = true;
        }
    }
}
}