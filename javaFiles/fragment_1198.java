package mainaxe;

public class Timex extends Thread {

    public static int a;

    public Timex() {
        super();
    }

    @Override
    public void run() {
        timedel();
    }

    public int timedel() {
        for (int i = 0; i < 200; i++) {
            try {
                Thread.sleep(1000);
                a = a + 5;
            } catch (InterruptedException e) {
            }

            // start();
        }
        return a;
    }
}