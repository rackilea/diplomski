private final Object monitor = new Object();

public void methodA() {
  synchronized (monitor) {
    // Do something with exclusive access.
  }
}

public void methodB() {
  synchronized (monitor) {
    // Do something with exclusive access.
  }
}