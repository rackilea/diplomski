public class TestClass {

  @Mock
  private HttpSession session;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test    
  public void testMethod() {
    Mockito.doReturn("ok").when(session).getAttribute("abc");
    ...
    classToTest.doIt(session);
  } 
}