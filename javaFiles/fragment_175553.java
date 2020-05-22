@RunWith(MockitoJUnitRunner.class}
class MyHandlerTest {

  @Spy  
  @InjectMocks  
  private MyHandler myHandler;  

  @Mock  
  private MyDependency myDependency;  

  @Test  
  public void testSomeMethod() {  
    doReturn(1).when(myHandler).anotherMethod();  
    assertEquals(myHandler.someMethod() == 1);  
    verify(myHandler, times(1)).anotherMethod();  
  }  
}