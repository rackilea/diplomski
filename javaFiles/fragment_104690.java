import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String args[]){


        AtomicInteger i = new AtomicInteger(0);
        i.set(0);
        TestingT thread1 = new TestingT(i);
        TestingT thread2 = new TestingT(i);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute( thread1 );
        executor.execute( thread2 );

        executor.shutdown();
    }
}
class TestingT implements Runnable {
    AtomicInteger i;
    TestingT(AtomicInteger i ){
        this.i = i;
    }
    @Override
    public void run(){
        while(this.i.get() < 100) {
            int i = this.i.incrementAndGet();
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}