public class Countdown implements Runnable{
    private final Thread t;

    public Countdown(){
        t = new Thread(this);
        t.start();
    }

    public Thread.State getState() {
        return t.getState();
    }
    // ...
}