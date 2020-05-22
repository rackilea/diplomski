import java.util.Timer;
import java.util.TimerTask;

public class ThreadTimer implements Runnable {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Thread(new ThreadTimer()).start();
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        ThreadTask task = new ThreadTask(Thread.currentThread());
        timer.schedule(task, 3000);

        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            System.out.println(Math.random() * 1000);
            // do whatever you want to do here
        }
    }

}

class ThreadTask extends TimerTask {

    private Thread thread;

    public ThreadTask(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        thread.interrupt();
        System.out.println("Thread has been terminated.");
    } // run
} // class ThreadTask