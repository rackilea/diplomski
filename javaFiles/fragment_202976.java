public class Updater implements Runnable {
    private Kulka kulka;
    private Thread t;

    public Updater(Kulka kulka) {
        this.kulka = kulka;
    }

    public void start() {
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }

    @Override
    public void run() {
        while (true) {
            kulka.update();
            try {
                Thread.sleep(16);
            } catch (InterruptedException ex) {
            }
        }
    }
}