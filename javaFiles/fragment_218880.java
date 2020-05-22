@ExtendWith(MockitoExtension.class)
public class CaptureTest {

    @InjectMocks
    MyClass classUnderTest;

    @Mock
    MyDep myDep;

    @Test
    public void test() {

        classUnderTest.callMyDepService();

        Captor<SomeClass> captor = ArgumentCaptor.forClass(SomeClass.class);
        Mockito.verify(myDep).serviceCall(captor.capture());

        SomeClass parameter = captor.getValue();
        // do assertions
    }
}