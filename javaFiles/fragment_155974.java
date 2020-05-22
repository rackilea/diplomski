import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

// https://stackoverflow.com/questions/56474713/parallel-tests-with-resource-lock
public class NamedResourceLocks {

    public static void main(String[] args) {

        System.out.println("Starting");
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            new NamedResourceLocks().run(executor);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }
        System.out.println("Done");
    }

    final static String userPrefix = "user";
    final static int maxUsers = 3;
    final static long maxWait = 10_000; // 10 seconds
    final static long startTime = System.currentTimeMillis();

    final Map<String, ReentrantLock> userLocks = new ConcurrentHashMap<>();
    final int maxTests = maxUsers * 10;
    final CountDownLatch allTestsDone = new CountDownLatch(maxTests);

    void run(ExecutorService executor) throws Exception {

        IntStream.range(0,  maxUsers).forEach(u -> 
            userLocks.put(userPrefix + u, new ReentrantLock(true)));
        IntStream.range(0,  maxTests).forEach(t -> 
            executor.execute(new Test(this, random.nextInt(maxUsers), t)));
        if (allTestsDone.await(maxWait, TimeUnit.MILLISECONDS)) {
            System.out.println("All tests finished");
        }
    }


    void lock(String user) throws Exception {

        ReentrantLock lock = userLocks.get(user);
        if (!lock.tryLock(maxWait, TimeUnit.MILLISECONDS)) {
            throw new RuntimeException("Waited too long.");
        }
    }

    void unlock(String user) {

        userLocks.get(user).unlock();
    }

    void oneTestDone() {

        allTestsDone.countDown();
    }

    final static Random random = new Random();

    static class Test implements Runnable {

        final NamedResourceLocks locks;
        final String user;
        final int testNumber;

        public Test(NamedResourceLocks locks, int userNumber, int testNumber) {
            this.locks = locks;
            this.user = userPrefix + userNumber;
            this.testNumber = testNumber;
        }

        @Override
        public void run() {

            boolean haveLock = false;
            try {
                log(this, "acquiring lock");
                locks.lock(user);
                haveLock = true;
                int sleepTime = random.nextInt(maxUsers) + 1; 
                log(this, "sleeping for " + sleepTime + " ms.");
                Thread.sleep(sleepTime);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (haveLock) {
                    log(this, "releasing lock");
                    locks.unlock(user);
                }
                locks.oneTestDone();
            }
        }

    }

    static void log(Test test, String msg) {
        System.out.println((System.currentTimeMillis() - startTime) + " - " +
                test.testNumber + " / " + test.user + " - " + msg);
    }
}