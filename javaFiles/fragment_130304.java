public static <T extends Comparable<T>> void sort(int[] numberArray) {
        if (numberArray == null || numberArray.length == 0) {
            return;
        }

        final AtomicInteger count = new AtomicInteger(1);
        pool.execute(new QuicksortRunnable<T>(numberArray, 0, numberArray.length - 1, count));

        while (count.get() > 0) {
            synchronized (count) {
                count.wait();
            }
        }
    }