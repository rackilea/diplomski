@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {

    @Mock
    private AppleFactory appleFactoryMock;

    @Mock
    private Apple appleMock;

    @InjectMocks 
    MyClass myClass;

    @Before
    public void setup() {
        when(appleFactoryMock.createInstance(Matchers.anyString()).thenReturn(appleMock);
    }

    @Test
    public void myMethod(){
     ...
     ...
     ...
    }
}