class Test {
  private int count = 0;
  <Z extends Test> void m(Z z) {
    count = z.count;  // Legal in javac 1.6, illegal in javac 1.7 due to fix for 6711619
  }
}