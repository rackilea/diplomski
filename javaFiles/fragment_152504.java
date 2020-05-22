private void test(DoSomething<E> m, E expectedValue) {
  try {
    if(!m.doSomething().equals(expectedValue))
      System.out.println("FAILED TEST");
  } catch() {
    //handle exception
  }
}