import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ObjectPool implements Callable {

    public static ConcurrentLinkedQueue<Integer> locked = new ConcurrentLinkedQueue<>();
    public static ConcurrentLinkedQueue<Integer> unlocked = new ConcurrentLinkedQueue<>();

    static {
        int one = 1;
        int two = 2;
        int three = 3;
        int four = 4;
        unlocked.add(one);
        unlocked.add(two);
        unlocked.add(three);
        unlocked.add(four);
    }

    public Object get() throws InterruptedException {
        synchronized (getClass()) {
            while (unlocked.size() == 0) {
                System.out.println("Thread entering into waiting state : "+Thread.currentThread().getName()+" for Object this : "+this.toString());
                this.getClass().wait();
            }
            Integer i =  unlocked.poll();
            locked.add(i);
            return i;
        }
    }

    public void leave() {
        synchronized (getClass()) {
            Integer left =  locked.poll();
            unlocked.add(left);
            this.getClass().notifyAll();
        }
    }

    @Override
    public Object call() throws Exception {
        Object o1 = get();
        System.out.println("Thread going to sleep after getting lock : " + Thread.currentThread().getName() + ".." + o1.toString());
        Thread.sleep(5000);
        System.out.println("Thread Giving Notification : " + Thread.currentThread().getName() + ".." + o1.toString());
        leave();
        return o1;
    }
}

public class Driver {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(" Main method");

        ObjectPool[] op = {new ObjectPool(), new ObjectPool(), new ObjectPool(), new ObjectPool(), new ObjectPool(), new ObjectPool(), new ObjectPool(), new ObjectPool()};

        ExecutorService es = Executors.newFixedThreadPool(8);

        for (ObjectPool o : op) {
            es.submit(o);
        }
    }
}