private AtomicInteger number = new AtomicInteger(0);

 public void updateNumber(int n) {
   number.getAndSet(n);
 }

 public int getNumber() {
   return number.get();
 }