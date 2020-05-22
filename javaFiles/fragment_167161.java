package net.sanjayts.test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.util.concurrent.TimeUnit;

public class ThreadDumpTest {

    public static void main(String[] args) throws Exception {
        final Object lock = new Object();
        for (int i = 0; i < 6; ++i) {
            final int cnt = i;
            new DaemonThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // If counter is even, try to acquire common lock and then
                        // sleep. If odd, sleep without trying to acquire the lock.
                        // This way, if we do a thread dump, we'll see threads in
                        // different states (TIMED_WAIT for those sleeping threads
                        // and BLOCKED for those waiting for the common "lock".
                        if (cnt % 2 == 0) {
                            synchronized (lock) {
                                TimeUnit.MINUTES.sleep(1); // sleep 1 min
                            }
                        } else {
                            TimeUnit.MINUTES.sleep(1); // sleep 1 min
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "mythread-" + cnt).start();
        }
        ThreadInfo[] infos = ManagementFactory.
                getThreadMXBean().dumpAllThreads(true, true);
        for (ThreadInfo info : infos) {
            System.out.println(info);
            System.out.println("===========================");
        }
        TimeUnit.SECONDS.sleep(2);
    }

}

class DaemonThread extends Thread {
    public DaemonThread(Runnable r, String name) {
        super(r, name);
        setDaemon(true);
    }
}