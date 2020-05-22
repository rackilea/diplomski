public class LockTester implements Runnable {

private int id;
private String fileName;
private LockType type;

public LockTester(int id, String fileName, LockType type) {

    this.id = id;
    this.fileName = fileName;
    this.type = type;
}

@Override
public void run() {
    try {
        System.out.println("Consumer" + id + " acquiring " + type + " for "
                + fileName);
        LockRegistry.INSTANCE.acquire(fileName, type);

        System.out.println("Consumer" + id + " holding " + type + " for "
                + fileName);

        // hold the lock for 2 seconds
        Thread.sleep(2000);

    } catch (InterruptedException e) {

        e.printStackTrace();
    } finally {

        LockRegistry.INSTANCE.release(fileName, type);

        System.out.println("Consumer" + id + " release " + type + " for "
                + fileName);
    }
}

public static void main(String[] args) {

    List<Thread> testThreads = new ArrayList<Thread>();

    testThreads.add(new Thread(new LockTester(1, "file1", LockType.READ)));
    testThreads.add(new Thread(new LockTester(2, "file1", LockType.READ)));
    testThreads.add(new Thread(new LockTester(3, "file1", LockType.WRITE)));
    testThreads.add(new Thread(new LockTester(4, "file1", LockType.WRITE)));
    testThreads.add(new Thread(new LockTester(5, "file2", LockType.WRITE)));
    testThreads.add(new Thread(new LockTester(6, "file3", LockType.WRITE)));
    testThreads.add(new Thread(new LockTester(7, "file4", LockType.WRITE)));

    for (Thread t : testThreads) {
        t.start();
    }

}

}