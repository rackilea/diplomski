public class TestClass {
  public static class DoSomething {
    private Call callee;

    public void execute() {
      callee.call();
    }
  }

  public static class Call {
    public void call() {
      System.out.println("real");
    }
  }

  @Tested DoSomething doSomething;
  //@Injectable Call call;

  // nothing happens
  @Test
  public void testRealCall() {
    Deencapsulation.setField(doSomething, "callee", new Call());
    doSomething.execute();
  }

  // invocation doesn't help either
  @Test
  public void testRealCallSecondTry() {
    new MockUp<Call>() {
      @Mock
      @SuppressWarnings("unused")
      public void call(Invocation inv) {
        inv.proceed();
      }
    };
    Deencapsulation.setField(doSomething, "callee", new Call());
    doSomething.execute();
  }

  // this works, but requires redundant methods
  @Test
  public void testRealCallThirdTry() {
    new MockUp<Call>() {
      @Mock
      @SuppressWarnings("unused")
      public void call() {
        System.out.println("real");
      }
    };
    Deencapsulation.setField(doSomething, "callee", new Call());
    doSomething.execute();
  }

  @Test
  public void testFakeCall() {
    new MockUp<Call>() {
      @Mock
      @SuppressWarnings("unused")
      public void call() {
        System.out.println("fake");
      }
    };
    Deencapsulation.setField(doSomething, "callee", new Call());
    doSomething.execute();
  }
}