@RunWith(MockitoJUnitRunner.class)
public class MyLauncherTest {

    @InjectMocks
    private ClassOne c1 = new ClassOne();

    @Mock
    private AutowiredClass a1;

    @Mock
    private AutowiredClass a2;

    @Test
    public void methodOne() {
        c1.methodOne(); // call the not mocked method
        Mockito.verify(a1).method1(); //verify if the a1.method() is called inside the methodOne
    }
}