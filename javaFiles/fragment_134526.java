Prime.primeList = new ArrayBlockingQueue<>(1000); // Guaranteed to be enough
int step = 1000 / nThreads + 1;
for(int i = 0; i<nThreads; i++){
    pThreads[i] = new Prime(i * step, Math.min(1000, (i + 1) * step - 1));
    pThreads[i].start();
}