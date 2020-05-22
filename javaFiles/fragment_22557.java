public class Cworker extends Bmain implements Runnable {
    Arunnable a;
    Cworker(Arunnable a) {
        this.a = a;
        a.subscribe(this);
    }
    public void run() {
        loop("Cworker");
    }
}