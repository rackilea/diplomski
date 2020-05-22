import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QTest {
    public static void main(String[] args){
        //create executor with exactly one thread (first four arguments) that is
        //using priority queue to store tasks (it takes care of sorting by priority)
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue());
        executor.execute(new EventWrapper(1, "A"));
        executor.execute(new EventWrapper(2, "B"));
        executor.execute(new EventWrapper(1, "C"));
        executor.execute(new EventWrapper(3, "D"));
        executor.execute(new EventWrapper(1, "E"));
        //just to have it terminated once test is done
        executor.shutdown();
    }
}

//in this wrapper should be loaded anything you want to have executed
class EventWrapper implements Comparable<EventWrapper>, Runnable{
    public final long priority;
    //name just to recognize what is being executed
    public final String name;
    public EventWrapper(int priority, String name){
        //priority function out of current time, can be obviously inserted from elsewhere
        this.priority = priority*System.currentTimeMillis();
        this.name = name;
    }

    @Override
    public int compareTo(EventWrapper that) {
        //lower priority first
        if(this.priority==that.priority)return 0;
        return this.priority>that.priority?1:-1;
    }

    @Override
    public void run() {
        System.out.println("Executing task "+name+" with priority "+priority);
        //sleep to rule out speed of insertion in executor
        try {Thread.sleep(1000);
        } catch (InterruptedException ex) {}
    }
}