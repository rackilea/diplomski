public class MyClassTest {
    @InjectMocks
    private MainClass mainClass;

    @Mock
    private CustomObject mockCustomObject;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);  // or use mockito runner
    }

    @Test
    public void testMakeCall() {
        when(mockCustomObject.testMethod()).thenReturn(...);
        mainClass.makeCall();
        verify(mockCustomObject).testMethod();
    }
}