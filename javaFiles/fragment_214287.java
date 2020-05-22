import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class SerialTaskQueue {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        // all operations on this list must be synchronized on the list itself.
        SerialTaskQueue tq = new SerialTaskQueue(executor);
        try {
            // test running the tasks one by one
            tq.add(new SleepSome(10L));
            Thread.sleep(5L);
            tq.add(new SleepSome(20L));
            tq.add(new SleepSome(30L));

            Thread.sleep(100L);
            System.out.println("Queue size: " + tq.size()); // should be empty
            tq.add(new SleepSome(10L));

            Thread.sleep(100L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }
    }

    // all lookups and modifications to the list must be synchronized on the list.
    private final List<Runnable> tasks = new LinkedList<Runnable>();
    // atomic boolean used to ensure only 1 task is executed at any given time
    private final AtomicBoolean executeNextTask = new AtomicBoolean(true);
    private final Executor executor;

    public SerialTaskQueue(Executor executor) {
        this.executor = executor;
    }

    public void add(Runnable task) {

        synchronized(tasks) { tasks.add(task); }
        runNextTask();
    }

    private void runNextTask() {
        // critical section that ensures one task is executed.
        synchronized(tasks) {
            if (!tasks.isEmpty()
                    && executeNextTask.compareAndSet(true, false)) {
                executor.execute(wrapTask(tasks.remove(0)));
            }
        }
    }

    private CallbackTask wrapTask(Runnable task) {

        return new CallbackTask(task, new Runnable() {
            @Override public void run() {
                if (!executeNextTask.compareAndSet(false, true)) {
                    System.out.println("ERROR: programming error, the callback should always run in execute state.");
                }
                runNextTask();
            }
        });
    }

    public int size() {
        synchronized(tasks) { return tasks.size(); }
    }

    public Runnable get(int index) {
        synchronized(tasks) { return tasks.get(index); }
    }

    public Runnable remove(int index) {
        synchronized(tasks) { return tasks.remove(index); }
    }

    // general callback-task, see https://stackoverflow.com/a/826283/3080094
    static class CallbackTask implements Runnable {

        private final Runnable task, callback;

        public CallbackTask(Runnable task, Runnable callback) {
            this.task = task;
            this.callback = callback;
        }

        @Override public void run() {
            try {
                task.run();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    callback.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // task that just sleeps for a while
    static class SleepSome implements Runnable {

        static long startTime = System.currentTimeMillis();

        private final long sleepTimeMs;
        public SleepSome(long sleepTimeMs) {
            this.sleepTimeMs = sleepTimeMs;
        }
        @Override public void run() {
            try { 
                System.out.println(tdelta() + "Sleeping for " + sleepTimeMs + " ms.");
                Thread.sleep(sleepTimeMs);
                System.out.println(tdelta() + "Slept for " + sleepTimeMs + " ms.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private String tdelta() { return String.format("% 4d ", (System.currentTimeMillis() - startTime)); }
    }
}