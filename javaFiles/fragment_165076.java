import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class TestJava {

    public static void main(String[] args) throws Exception {
        final CountDownLatch cdl = new CountDownLatch(3);
        final Map<String, Object> res = new ConcurrentHashMap<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                res.put("first", 1);    // imagine this is the query result
                cdl.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                res.put("second", 2);   // imagine this is the query result
                cdl.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                res.put("third", 3);    // imagine this is the query result
                cdl.countDown();
            }
        }).start();

        cdl.await();

        System.out.println("res size = " + res.size());

    }
}