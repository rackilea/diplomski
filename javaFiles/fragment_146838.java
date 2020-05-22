public static Timer time = new Timer();
public static Thread runningThread = null;
public static int j = 0;

public static void main(String[] args) {
    try {
        testrun();
        Thread.sleep(2000);
        time.cancel();
        System.out.println("timer stop");
        if (runningThread != null) {
            // Interrupt the thread.
            runningThread.interrupt();
        }
        System.out.println(j);

    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

public static void testrun() {
    time.schedule(new TimerTask() {
        @Override
        public void run() {
            // Catch the thread that is running my task.
            runningThread = Thread.currentThread();
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                j++;
            }

            System.out.println("End timer");
        }
    }, 1000, 1000);
}