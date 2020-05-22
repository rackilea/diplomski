import java.lang.Thread;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object test = new Object();
        ReferenceQueue<Object> q = new ReferenceQueue<Object>();
        PhantomReference<Object> p = new PhantomReference<Object>(test, q);
        Object lock = new Object();
        while (true) {
            System.out.println("Checking queue...");
            if (q.poll() != null) {
                break;
            }
            System.out.println("Still polling...");
            System.gc();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
                break;
            }
            // Make the object garbage...
            test = null;
        }
        System.out.println("Finished.");
    }
}