private synchronized void cooldown(long ms) {
    try {
       long waitUntilMillis = System.currentTimeMillis() + ms;
       long waitTimeMillis = ms;
       do {
          this.wait(waitTimeMillis);
          // we need this dance/loop because of spurious wakeups, thanks @loki
          waitTimeMillis = waitUntilMillis - System.currentTimeMillis();
       } while (waitTimeMillis > 0);
    } catch (InterruptedException e) {
       Thread.currentThread.interrupt();
    }
}