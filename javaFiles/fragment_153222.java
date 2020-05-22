import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

// Adapted from https://stackoverflow.com/a/33113200/3080094
public class GridTaskExecutor {

    public static void main(String[] args) {

        final int maxTasks = 10_000;
        final CountDownLatch tasksDone = new CountDownLatch(maxTasks);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(16);
        try {
            GridTaskExecutor gte = new GridTaskExecutor(executor); 
            Random r = new Random();

            for (int i = 0; i < maxTasks; i++) {

                final int nx = r.nextInt(10);
                final int ny = r.nextInt(10);

                Runnable task = new Runnable() { 
                    public void run() { 
                        try {
                            // System.out.println("Task " + nx + " / " + ny + " is running");
                            Thread.sleep(1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            tasksDone.countDown();
                        }
                    } 
                };
                gte.addTask(task, nx, ny);
            }
            tasksDone.await();
            System.out.println("All tasks done, task points remaining: " + gte.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }
    }

    private final Executor executor;
    private final Map<Long, List<CallbackPointTask>> tasksWaiting = new HashMap<>();
    // make lock fair so that adding and removing tasks is balanced.
    private final ReentrantLock lock = new ReentrantLock(true);

    public GridTaskExecutor(Executor executor) {
        this.executor = executor;
    }

    public void addTask(Runnable r, int x, int y) {

        Long point = toPoint(x, y);
        CallbackPointTask pr = new CallbackPointTask(point, r);
        boolean runNow = false;
        lock.lock();
        try {
            List<CallbackPointTask> pointTasks = tasksWaiting.get(point);
            if (pointTasks == null) {
                if (tasksWaiting.containsKey(point)) {
                    pointTasks = new LinkedList<CallbackPointTask>();
                    pointTasks.add(pr);
                    tasksWaiting.put(point, pointTasks);
                } else {
                    tasksWaiting.put(point, null);
                    runNow = true;
                }
            } else {
                pointTasks.add(pr);
            }
        } finally {
            lock.unlock();
        }
        if (runNow) {
            executor.execute(pr);
        }
    }

    private void taskCompleted(Long point) {

        lock.lock();
        try {
            List<CallbackPointTask> pointTasks = tasksWaiting.get(point);
            if (pointTasks == null || pointTasks.isEmpty()) {
                tasksWaiting.remove(point);
            } else {
                System.out.println(Arrays.toString(fromPoint(point)) + " executing task " + pointTasks.size());
                executor.execute(pointTasks.remove(0));
            }
        } finally {
            lock.unlock();
        }
    }

    // for a general callback-task, see https://stackoverflow.com/a/826283/3080094
    private class CallbackPointTask implements Runnable {

        final Long point;
        final Runnable original;

        CallbackPointTask(Long point, Runnable original) {
            this.point = point;
            this.original = original;
        }

        @Override
        public void run() {

            try {
                original.run();
            } finally {
                taskCompleted(point);
            }
        }
    }

    /** Amount of points with tasks. */ 
    public int size() {

        int l = 0;
        lock.lock();
        try {
            l = tasksWaiting.size(); 
        } finally {
            lock.unlock();
        }
        return l;
    }

    // https://stackoverflow.com/a/12772968/3080094
    public static long toPoint(int x, int y) {
        return (((long)x) << 32) | (y & 0xffffffffL);
    }

    public static int[] fromPoint(long p) {
        return new int[] {(int)(p >> 32), (int)p };
    }

}