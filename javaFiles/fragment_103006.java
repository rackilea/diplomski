public static void main(String[] args) throws InterruptedException {
    long currentTime = System.currentTimeMillis();
    long releaseTime = currentTime + 1000 * 60 * 60 * 24 * 3; // 3 days

    Thread.sleep(releaseTime - currentTime);
}