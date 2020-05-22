import java.util.concurrent.ArrayBlockingQueue;

public class Bmain {
    ArrayBlockingQueue<String> messageQueue;
    Bmain() {
        messageQueue = new ArrayBlockingQueue<String>(10 /* capacity */, true /* fair? */);
    }
    public void doit() {
        Arunnable ar = new Arunnable();
        Thread a = new Thread(ar);
        a.setDaemon(false);
        a.start();

        Thread b = new Thread(new Cworker(ar));
        b.setDaemon(false);
        b.start();

        ar.subscribe(this);
        loop("Bmain  ");
    }
    public static void main(String[] args) {
        (new Bmain()).doit();
    }
    public void publish(String msg) {
        try {
            messageQueue.put(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loop(String who) {
        try {
            for (;;) {
                String s = messageQueue.take();
                System.out.printf("%s got [%s]\n", who, s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}