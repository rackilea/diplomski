while (true) {
    if (this.lock.tryLock()) {
        try {
          if (ba.lock.tryLock()) {
            try {
             //some logic
              break;
            } finally {
              ba.lock.unlock();
            }
          }
        } finally {
          this.lock.unlock();
        }
    }
    int n = number.nextInt(1000);
    int TIME = 1000 + n; // 1 second + random delay to prevent livelock
    Thread.sleep(TIME);
}