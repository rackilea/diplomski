for (int i = 0; i < numberOfThreads; i++) {
    worker[i] = new Thread(new CountPrimesRunnable(c));
    worker[i].start();
}

for (int i = 0; i < numberOfThreads; i++) {
    worker[i].join();
}