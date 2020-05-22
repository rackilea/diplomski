@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    @Mock
    private MyOtherService myServiceRegistryConsumer;

    @InjectMocks
    private MyServiceImpl myServiceImpl;

    @Test
    public void testSomething() {
        // e.g. define behavior for the injected field
        when(myServiceRegistryConsumer.methodA()).thenReturn(/* mocked return value */);
    }
}