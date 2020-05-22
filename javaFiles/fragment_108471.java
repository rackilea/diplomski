public Foo computeFoo() {
  try {
    // 1
    return firstVersion();
  } catch (Exception e) {
    // 2
    return secondVersion();
  }
}