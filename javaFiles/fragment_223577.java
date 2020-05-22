public class AutoUpdater implements Runnable {
    public void run() {
        while (true) {
            try {
                System.out.println("Thread is running...");
                for (int i = 0; i < clients.size(); i++) {
                    // do something...
                }
            } finally {
                System.out.println("Thread ended.\n");
            }

            int time = 1000 * 60 * 60 * 24;
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.out.println("Something interrputed thread while running.");
            }
        }
    }
}