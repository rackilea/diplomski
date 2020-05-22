while(...) {
  doWork();
  synchronized( SomeClass.class ) {
    update();
  }
}