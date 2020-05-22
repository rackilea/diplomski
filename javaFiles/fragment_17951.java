class Scratch {

    private static volatile boolean isRunning = true;

    public static void main(String[] args) {
        Thread Task1 = new Thread(new Task1());
        Task1.start();

        Thread Task2 = new Thread(new Task2());
        Task2.start();

        // ... more threads
    }

    public class Task1 implements Runnable {
        public void run() {
            while (isRunning) {
                // ...
                isRunning = false; // let's stop all threads
                // ...
            }
        }
    }

    public class Task2 implements Runnable {
        public void run() {
            while (isRunning) {
                // ...
                // I need to know about System.exit(0) to exit my loop
                // ...
            }
        }
    }
}