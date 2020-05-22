private final AtomicLong pendingAndComplete = new AtomicLong();

void markComplete() {
  this.pendingAndComplete.addAndGet(1L<<32-1); // this is atomic
}
void markPending() {
  this.pendingAndComplete.incrementAndGet(); // this is atomic
}

void doSomething() {
  long current = this.pendingAndComplete.get(); // this fetches the current state atomically

  int currentCompleted = (int)(current >> 32);
  int currentPending = (int) current;
}