public class Locking {

    private static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(Locking::lockSeveralTimes);
        Thread t2 = new Thread(Locking::lockOnce);
        t1.start();
        Thread.sleep(100); // give t1 some time to start
        t2.start();
    }

    protected static void lockOnce() {
        synchronized (o) {
            System.out.println("DONE");
        }
    }

    protected static void lockSeveralTimes() {
        try {
            System.out.println("Has Lock: " + Thread.holdsLock(o));
            synchronized (o) {
                System.out.println("Aquired Lock: " + Thread.holdsLock(o) + " / Times: " + getLockedMonitorsCount());
                waitOneSecond();
                synchronized (o) {
                    System.out.println("Aquired Lock: " + Thread.holdsLock(o) + " / Times: " + getLockedMonitorsCount());
                    waitOneSecond();
                    synchronized (o) {
                        System.out.println("Aquired Lock: " + Thread.holdsLock(o) + " / Times: " + getLockedMonitorsCount());
                        waitOneSecond();
                        System.out.println("Going to release lock. Still holds: " + Thread.holdsLock(o) + " / Times: " + getLockedMonitorsCount());
                    }
                    waitOneSecond();
                    System.out.println("Going to release lock. Still holds: " + Thread.holdsLock(o) + " / Times: " + getLockedMonitorsCount());
                }
                waitOneSecond();
                System.out.println("Going to release lock. Still holds: " + Thread.holdsLock(o) + " / Times: " + getLockedMonitorsCount());
            }
            System.out.println("Still holds: " + Thread.holdsLock(o));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static void waitOneSecond() throws InterruptedException {
        Thread.sleep(1000);
    }

    protected static int getLockedMonitorsCount() {
        return ManagementFactory.getThreadMXBean().getThreadInfo(new long[] { Thread.currentThread().getId() }, true, false)[0].getLockedMonitors().length;
    }

}