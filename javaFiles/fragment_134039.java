public class MyFoo1Test {

  @Mock private MyFoo2 mockMyFoo2;

  @InjectMocks
  private MyFoo1 myFoo1 = new MyFoo1();

  @Test
  public void testHandlerName1() {
    Object o = new Object("Name1"); 
    myFoo1.handler(o);
    verify(myFoo2).doSomeStuff1(o);
  }

  @Test
  public void testHandlerName2() {
    Object o = new Object("Name2"); 
    myFoo1.handler(o);
    verify(myFoo2).doSomeStuff2(o);
  }

  @Test
  public void testHandlerOtherName() {
    Object o = new Object("OtherName"); 
    myFoo1.handler(o);
    verifyZeroInteractions(myFoo2);
  }

}