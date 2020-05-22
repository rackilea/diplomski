private final AtomicBoolean flag = new AtomicBoolean();

while (!flag.compareAndSet(false, true));
try {
  //your code here
} finally {
  flag.set(false);
}