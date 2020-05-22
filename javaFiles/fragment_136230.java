public class SouthThread extends Thread {
    protected Queue<Car> q = new LinkedList<Car>();
    protected North north;

    public void CreateQueue() { ... }
    public void poll() { ... }

    public void run() {
        boolean done = false;
        while (!done) {
            // wait two seconds
            try {
                Thread.sleep(2000);
            } (catch InterruptedException) { /* TODO */ }

            // process one element from the queue
            poll();

            // notify the other thread
            synchronized (north) {
                north.notifyAll();
            }

            // wait until the other thread notifies this one
            try {
                synchronized (this) {
                    wait();
                }
            } (catch InterruptedException) { /* TODO */ }
        }
    }
}

public class NorthThread extends Thread {
    protected Queue<Car> q = new LinkedList<Car>();
    protected South south;

    public void CreateQueue() { ... }
    public void poll() { ... }

    public void run() {
        boolean done = false;
        while (!done) {
            // wait two seconds
            try {
                Thread.sleep(2000);
            } (catch InterruptedException) { /* TODO */ }

            // process one element from the queue
            poll();

            // notify the other thread
            synchronized (south) {
                south.notifyAll();
            }

            // wait until the other thread notifies this one
            try {
                synchronized (this) {
                    wait();
                }
            } (catch InterruptedException) { /* TODO */ }
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        SouthThread tSouthThread = new SouthThread();
        NorthThread tNorthThread = new NorthThread();

        tSouthThread.north = tNorthThread;
        tNorthThread.south = tSouthThread;

        tSouthThread.CreateQueue();
        tNorthThread.CreateQueue();

        tSouthThread.start();
        tNorthThread.start();    
    }
}