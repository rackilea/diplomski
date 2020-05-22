import com.sun.management.ThreadMXBean;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Iterator;


public class EscapeAnalysisTest {

    private static final long TIME_TO_TEST = 10L * 1000L; // 10s

    static class Timestamp {
        private long millis;

        public Timestamp(long millis) {
            this.millis = millis;
        }

        public long getTime() {
            return millis;
        }

        public void setTime(long time) {
            millis = time;
        }
    }

    public static void main(String[] args) {
        System.out.println("****");
        doIt();
        System.out.println("****");
        doIt();
        System.out.println("****");
        doIt();
        System.out.println("****");
        doIt();
        System.out.println("****");
    }

    private static void doIt() {
        final ThreadMXBean mxbean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
        final long tid = Thread.currentThread().getId();
        long r = 0;
        final long allocPre = mxbean.getThreadAllocatedBytes(tid);
        r += test1();
        long alloc1 = mxbean.getThreadAllocatedBytes(tid);
        System.out.println("test1 - " + (alloc1 - allocPre));
        r += test2();
        final long alloc2 = mxbean.getThreadAllocatedBytes(tid);
        System.out.println("test2 - " + (alloc2 - alloc1));
        r += test3();
        final long alloc3 = mxbean.getThreadAllocatedBytes(tid);
        System.out.println("test3 - " + (alloc3 - alloc2));
        r += test4();
        final long alloc4 = mxbean.getThreadAllocatedBytes(tid);
        System.out.println("test4 - " + (alloc4 - alloc3));
        r += test5();
        final long alloc5 = mxbean.getThreadAllocatedBytes(tid);
        System.out.println("test5 - " + (alloc5 - alloc4));
        r += test6();
        final long alloc6 = mxbean.getThreadAllocatedBytes(tid);
        System.out.println("test6 - " + (alloc6 - alloc5));
        System.out.println(r);
    }

    public static long test1() {
        long r = 0;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < TIME_TO_TEST) {
            r += new Timestamp(System.currentTimeMillis()).getTime();
        }
        return r;
    }

    public static long test2() {
        ArrayList<Integer> l = new ArrayList<Integer>(1000);
        for (int i = 0; i < 1000; ++i) {
            l.add(i);
        }
        long r = 0;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < TIME_TO_TEST) {
            for (Iterator<Integer> it = l.iterator(); it.hasNext(); ) {
                r += it.next().longValue();
            }
        }
        return r;
    }

    public static long test3() {
        long r = 0;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < TIME_TO_TEST) {
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            ts.setTime(42);
            r += ts.getTime();
        }
        return r;
    }

    public static long test4() {
        ArrayList<Integer> l = new ArrayList<Integer>(1000);
        for (int i = 0; i < 1000; ++i) {
            l.add(i);
        }
        long r = 0;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < TIME_TO_TEST) {
            Iterator<Integer> it = l.iterator();
            r += it.next().longValue();
            r += it.next().longValue();
            r += it.next().longValue();
            r += it.next().longValue();
        }
        return r;
    }

    public static long test5() {
        ArrayList<Integer> l = new ArrayList<Integer>(1000);
        for (int i = 0; i < 1000; ++i) {
            l.add(i);
        }
        long r = 0;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < TIME_TO_TEST) {
            Iterator<Integer> it = l.iterator();
            for (int i = 0; i < l.size(); ++i) {
                r += it.next().longValue();
            }
        }
        return r;
    }

    public static long test6() {
        long r = 0;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < TIME_TO_TEST) {
            for (Timestamp ts = new Timestamp(System.currentTi());
                 ts.getTime() > 0;
                 ts.setTime(ts.getTime() + System.currentTimeMillis())) {
                r += ts.getTime();
            }
        }
        return r;
    }

}