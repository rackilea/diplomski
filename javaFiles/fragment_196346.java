@Override
public void run() {
    try {
        while (true) {
            synchronized (this) {
                num++; // initially assigning int num = 0, and then doing this
                if (num > 100) {
                    break;
                }
                if (isPrime(num)) {
                    System.out.println(num);
                }
            }
        }
    } finally {
        countdownLatch.countDown();
    }
}