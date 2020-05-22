synchronized void method1() {
  // ... do stuff ...
}

void method2() {
  synchronized(this) {
    // ... do stuff ...
  }
}