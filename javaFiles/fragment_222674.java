Thread[] threads = new Thread[10];
for (int i = 0; i < threads.length; ++i) {
    threads[i] = new Thread() {
        public void run() {
            doStuff();
        }
    };

    threads[i].start();
}