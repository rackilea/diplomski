@RunWith(PowerMockRunner.class)
@PrepareForTest(MyHandler.class)
public class MyHandlerTest {
    @InjectMocks
    MyHandler myHandler;
    @Test
    public void testMain() throws Exception {
        Utils utils = mock(Utils.class);
        when(utils.someMethod()).thenReturn(1);
        whenNew(Utils.class).withArguments(anyInt()).thenReturn(utils);
        myHandler.someMethod();
    }
}