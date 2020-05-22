public final class Test {
  // In this method.
  private void test() {
    // With this local variable.
    final List<String> localList = new LinkedList<String>();
    // We can define a class
    class InnerTest {
      // Yes you can!!
      void method () {
        // You can even access local variables but only if they are final.
        for ( String s : localList ) {
          // Like this.
        }
      }
    }
  }

}