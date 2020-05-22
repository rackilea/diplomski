public class MyTestClass{

   @Mock
   private Writer writerMock;

   @Mock
   private StreamReader streamStub;

   @InjectMocks
   public ClassUnderTest testClass;

   @Before
   public void init(){
      MockitoAnnotations.initMocks(this);
   }

   // one of three test cases
   @Test
   public void test_START_ELEMENT(){
        // Arrange
        Mockito.when(streamStub.hasNext()).thenReturn(true).thenReturn(false);   
        Mockito.when(streamStub.next()).thenReturn(XMLStreamConstants.START_ELEMENT);

        // Act
        testClass.readStream(streamStub);

        // Assert
        Mockito.verify(times(1), writerMock).writeStartElement();
   }
}