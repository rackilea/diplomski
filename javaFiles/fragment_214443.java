@RunWith(PowerMockRunner.class)
@PrepareForTest(Tests.class)
public class Tests {
    @Test
    public void testHandledByFirst() throws Exception {
        Request req = ...;
        Handler h1 = mock(Handler.class);
        Handler h2 = mock(Handler.class);

        when(h1, "setSuccessor", h2).thenCallRealMethod();
        when(h1, "handleRequestImpl", req).thenReturn(true);

        h1.setSuccessor(h2);
        h1.handleRequest(req);
        verify(h2, times(0)).handleRequest(req);
    }

    @Test
    public void testHandledBySecond() throws Exception {
        Request req = ...;
        Handler h1 = mock(Handler.class);
        Handler h2 = mock(Handler.class);

        when(h1, "setSuccessor", h2).thenCallRealMethod();
        when(h1, "handleRequestImpl", req).thenReturn(false);
        h1.setSuccessor(h2);

        h1.handleRequest(req);
        verify(h2, times(1)).handleRequest(req);
    }
}