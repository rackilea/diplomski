private final AtomicInteger atomicInt = new AtomicInteger(0);

private volatile int volatileInt = 0;

public void doStuff() {
  // To use the atomic int, you use the setters and getters!
  int gotAnInt = atomicInt.getAndIncrement();

  // To use a volatile, access and set it directly. 
  int gotAnotherInt = volatileInt;
  volatileInt = someOtherInt;
}