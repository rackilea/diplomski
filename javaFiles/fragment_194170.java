public class Test implements Runnable{

    private int x;

    public synchronized void run(){
        x++;
    }

    public synchronized int getX() {
        return x;
    }