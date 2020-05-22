public class JavaScheduledExecutorServiceExample {
    private static ScheduledExecutorService execService = null;
    private static int timesAsleep = 0;

    public static class MyTask implements Runnable {

        public void run() {
            System.out.println("hi there at: "+ new java.util.Date());
            // schedule again
            execService.schedule(new MyTask(), 1000, TimeUnit.MILLISECONDS);
            try {
                int i = timesAsleep;
                timesAsleep++;
                System.out.println("asleep " + i + "----------------------");
                Thread.sleep(5000);
                System.out.println("awoke " + i + "----------------------");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        execService = Executors.newScheduledThreadPool(5);
        execService.schedule(new MyTask(), 1000, TimeUnit.MILLISECONDS);
    }

}