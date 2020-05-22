public class Processor extends Thread {
    private volatile stopped;

    public void run() {
        while (!stopped) {
            // do stuff
        }
    }

    public void stop() {
        stopped = true;
    }
}

public class Test {
    public static void main(String[] args) {
        Processor p = new Processor();
        p.start();
        Thread.sleep(1000);
        p.stop();
    }
}