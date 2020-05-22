@RunWith(MockitoJUnitRunner.class)
public class HandlerTest {
    @Mock
    private Dispatcher dispatcher;
    @InjectMocks
    private Handler classUnderTest;
    @Captor
    private ArgumentCaptor<Runnable> registerMessageLambdaCaptor;

    @Test
    public void shouldCallDispatchMethod() {
        final String a = "foo";
        final String b = "bar";
        final long c = 42L;

        MessageHandler handler = mock(MessageHandler.class);

        classUnderTest.dispatchMessage(handler, a, b, c);

        verify(handler).registerMessage(registerMessageLambdaCaptor.capture());

        Runnable lambda = registerMessageLambdaCaptor.getValue();

        lambda.run();

        verify(dispatcher).dispatch(a, b, c);
    }
}