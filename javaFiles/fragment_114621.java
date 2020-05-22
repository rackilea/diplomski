final long startTime = System.currentTimeMillis();
ArrayList<Thread> threads = new ArrayList<Thread>();

for (final ExampleTimeoutNotifierListener l : listeners) {
    Thread t = new Thread() {
        @Override
        public void run() {
            try {
                l.collectBeforeAction();
            } catch (Exception e) {}
        }
    };
    t.start();
    threads.add(t);
}

for (Thread t : threads) {
    try {
        long timeoutLeft = timeOutInMillis - (System.currentTimeMillis() - startTime);
        if (timeoutLeft < 1) break;
        t.join();
    } catch (InterruptedException e) {}
}