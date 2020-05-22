CoolThread myThread = new CoolThread(1, 2);
// this must be done _before_ the thread starts below
myThread.defineMain(this);
Thread t_myThread = new Thread(myThread);
t_myThread.start();
...

public class CoolThread implements Runnable {
    public void run() {
        ...
    }
}