public class ShutDownHook {

    public static void main(String[] args) {

        final Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                // Add your cleanup logic here
                System.out.println("Shutdown hook is executing");
                try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        System.exit(0);
    }
}