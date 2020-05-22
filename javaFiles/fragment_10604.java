final int THREAD_COUNT = 10;
final int NUMS_TO_ADD = 100000;
Set<Integer> set = new HashSet<>();
Thread[] threads = new Thread[THREAD_COUNT];
for (int i = 0; i < THREAD_COUNT; i++) {
    final int threadNo = i;
    threads[i] = new Thread() {
        @Override public void run() {
            for (int j = 0; j < NUMS_TO_ADD; j++)
                set.add(j * THREAD_COUNT + threadNo); // all distinct values
        }
    };
    threads[i].start();
}
for (int i = 0; i < threads.length; i++)
    threads[i].join();
System.out.println("Found " + set.size() + " values, expected " + THREAD_COUNT * NUMS_TO_ADD);