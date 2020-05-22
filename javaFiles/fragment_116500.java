List<Thread> threads = new ArrayList<Thread>();
for (int i = 0; i < THREAD_COUNT; i++) {
    Thread thread = new Thread() {
        @Override
        public void run() {

            for (int j = 0; j < GENERATED_NUMBER_COUNT; j++) {
                int random = rand.nextInt(INT_RIGHT_BORDER);
                if (!counts.containsKey(random)) {
                    counts.put(random, 0);
                }
                counts.put(random, counts.get(random) + 1);
            }
        }
    };
    threads.add(thread);
    thread.start();
}

for (Thread thread: threads) {
    thread.join();
}