public class Main {
    public static volatile int x = 0;

    public static void main(String[] args) {
        LoopingThread t = new LoopingThread();
        System.out.println("Starting background thread...");
        t.start();

        while (true) {
            x = x++;
        }
    }
}

class LoopingThread extends Thread {
    public @Override void run() {
        while (true) {
            System.out.println(Main.x);
        }
    }
}