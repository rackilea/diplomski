// As a member variable instead of reqSync:
static final Semaphore MUTEX = new Semaphore(1);

// In the body:
public void actionPerformed(ActionEvent e) {
  if (MUTEX.tryAcquire()) {
    new Thread() {
      @Override public void run() {
        try {
          // ...
        } finally {
          MUTEX.release();
        }
      }
    }.start();
  }
}