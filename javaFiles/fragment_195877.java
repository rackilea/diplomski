public class XTest {
  @Test
  public void testExtensionVerify(){
    X x = mock(X.class);
    B b = new B();
    C c = new C();
    x.doSomething(b);
    x.doSomething(c);

    verify(x, times(1)).doSomething(isA(B.class));
    verify(x, times(1)).doSomething(isA(C.class));
  }
}