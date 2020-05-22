private final Object lock = new Object();

public int nonConcurrentMethod() {
  synchronized(lock) {
    ...reinitialize the map...change references...
    counter++;
    return array[counter];
  }
}