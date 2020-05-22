class Foo {
  @Advice.OnMethodEnter
  @Advice.OnMethodExit
  private static void intercept() {
    System.out.println("Before/after");
  }
}