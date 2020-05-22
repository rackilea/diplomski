@RunWith(PowerMockRunner.class)
@PrepareForTest(Tests.class)
public class Tests {
    @Test
    public void testHandledByFirst() throws Exception {
        Request req = ...;
        Callable c1 = mock(Callable.class);
        Callable c2 = mock(Callable.class);
        Handler handler = new Handler(c1, c2);

        when(c1.call(req)).thenReturn(true);

        handler.handle(req);

        verify(c1, times(1)).call(req);
        verify(c2, times(0)).call(req);
    }

    @Test
    public void testHandledBySecond() throws Exception {
        Request req = ...;
        Callable c1 = mock(Callable.class);
        Callable c2 = mock(Callable.class);
        Handler handler = new Handler(c1, c2);

        when(c1.call(req)).thenReturn(false);

        handler.handle(req);

        verify(c1, times(1)).call(req);
        verify(c2, times(1)).call(req);
    }
}