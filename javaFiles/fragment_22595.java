@RunWith(PowerMockRunner.class)
@PrepareForTest({/* Static Classes I am Mocking */})
public class ExampleTest {
  @Mock (name = "queueFactory") //same name as private var.
  QueueConnectionFactory queueFactoryMock;
  @Mock
  Connection connectionMock; //the object we want returned
  @InjectMocks
  Example exampleTester; //the class to test

  @Before
  public void setup(){
    MockitoAnnotations.initMocks(this); // initialize all the @Mock objects
    // Setup other Static Mocks
  }

  @Test
  public void testTestMe(){
    //Mock your objects like other "normally" mocked objects
    PowerMockito.when(queueFactoryMock.createConnection()).thenReturn(connectionMock);
    //...Mock ConnectionMock functionality...
    exampleTester.testMe();
  }
}