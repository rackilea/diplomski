import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

public class Arunnable implements Runnable {
    ArrayList<Bmain> subscribers = new ArrayList<Bmain>();
    public void run() {
        try {
            for (;;) {
                Thread.sleep(1000);
                String message = String.format("Hi! from Arunnable, now is %d", (new Date()).getTime());
                Iterator<Bmain> iter = subscribers.iterator();
                while (iter.hasNext()) {
                    Bmain o = iter.next();
                    o.publish(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void subscribe(Bmain o) {
        subscribers.add(o);
    }
}