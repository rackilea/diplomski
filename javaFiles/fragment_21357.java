public static void main(String[] args) throws Exception {

    final AtomicInteger sequencer = new AtomicInteger(1);
    final int[] integers = new int[1000];

    final Runnable task = new Runnable() {

        @Override
        public void run() {
            int next = sequencer.getAndIncrement();
            integers[next-1]++;
        }
    };
    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
        Thread t = new Thread(task);
        t.start();
        threads.add(t);
    }
    for (Thread t : threads) {
        t.join();
    }
    for (int i = 0; i < 1000; i++) {
        if (integers[i] != 1) System.out.println(i + " -> " + integers[i]);
    }
}