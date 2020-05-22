public void run() {
    synchronized (lock) {
        for (int a = i * (M / N); a < (i + 1) * (M / N); a++) {
            System.out.println("Thread " + (i + 1) + ":" + array[a]);
        }
    }
}