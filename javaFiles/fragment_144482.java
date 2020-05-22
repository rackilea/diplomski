synchronized (this) {
  b();
}

void b() {
  wait();
}