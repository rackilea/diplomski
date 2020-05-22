synchronized void a() {
  b();
}

void b() {
  wait();
}