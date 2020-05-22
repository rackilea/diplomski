package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class AAA {

    private static final long DURATION = TimeUnit.NANOSECONDS.convert(30, TimeUnit.SECONDS);
    private static final int THREADS_NUMBER = 2;
    private static final ThreadLocal<AtomicLong> COUNTER = new ThreadLocal<AtomicLong>() {
        @Override
        protected AtomicLong initialValue() {
            return new AtomicLong();
        }
    };
    private static final ThreadLocal<AtomicLong> DUMMY_DATA = new ThreadLocal<AtomicLong>() {
        @Override
        protected AtomicLong initialValue() {
            return new AtomicLong();
        }
    };
    private static final AtomicLong DUMMY_COUNTER = new AtomicLong();
    private static final AtomicLong END_TIME = new AtomicLong(System.nanoTime() + DURATION);

    private static final List<ThreadLocal<CharSequence>> DUMMY_SOURCE = new ArrayList<ThreadLocal<CharSequence>>();
    static {
        for (int i = 0; i < 40; ++i) {
            DUMMY_SOURCE.add(new ThreadLocal<CharSequence>());
        }
    }

    private static final Set<Long> COUNTERS = new ConcurrentSkipListSet<Long>();

    public static void main(String[] args) throws Exception {
        final CountDownLatch startLatch = new CountDownLatch(THREADS_NUMBER);
        final CountDownLatch endLatch = new CountDownLatch(THREADS_NUMBER);

        for (int i = 0; i < THREADS_NUMBER; i++) {
            new Thread() {
                @Override
                public void run() {
                    initDummyData();
                    startLatch.countDown();
                    try {
                        startLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (System.nanoTime() < END_TIME.get()) {
                        doJob();
                    }
                    COUNTERS.add(COUNTER.get().get());
                    DUMMY_COUNTER.addAndGet(DUMMY_DATA.get().get());
                    endLatch.countDown();
                }
            }.start();
        }
        startLatch.await();
        END_TIME.set(System.nanoTime() + DURATION);

        endLatch.await();
        printStatistics();
    }

    private static void initDummyData() {
        for (ThreadLocal<CharSequence> threadLocal : DUMMY_SOURCE) {
            threadLocal.set(getRandomString());
        }
    }

    private static CharSequence getRandomString() {
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 127; ++i) {
            result.append((char)random.nextInt(0xFF));
        }
        return result;
    }

    private static void doJob() {
        Random random = new Random();
        for (ThreadLocal<CharSequence> threadLocal : DUMMY_SOURCE) {
            for (int i = 0; i < threadLocal.get().length(); ++i) {
                DUMMY_DATA.get().addAndGet(threadLocal.get().charAt(i) << random.nextInt(31));
            }
        }
        COUNTER.get().incrementAndGet();
    }

    private static void printStatistics() {
        long total = 0L;
        for (Long counter : COUNTERS) {
            total += counter;
        }
        System.out.printf("Total iterations number: %d, dummy data: %d, distribution:%n", total, DUMMY_COUNTER.get());
        for (Long counter : COUNTERS) {
            System.out.printf("%f%%%n", counter * 100d / total);
        }
    }
}