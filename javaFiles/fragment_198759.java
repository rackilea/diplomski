public class TestWait {
    private static volatile boolean ready = false;

    public static void main(String[] args) throws Exception {
        final Object lock = new Object();
        Runnable waitingTask = new Runnable() {

            @Override
            public void run() {
                synchronized(lock) {
                    while(!ready) {
                        try {
                            System.out.println("Going to wait here");
                            lock.wait(1000);
                        } catch (InterruptedException ex) {
                            System.out.println("Thread interrupted");
                        }
                    }
                    System.out.println("I'm done waiting");
                }
            }
        };
        new Thread(waitingTask).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("main interrupted");
        }
        ready = true;
        System.out.println("ready");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("main interrupted");
        }
    }
}