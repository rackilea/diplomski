static final Object lockObj = new Object();

public void myMethod() {
  synchronized (lockObj) {
    // do something with globalObj here
  }
}