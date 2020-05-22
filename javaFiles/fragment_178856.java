@RunWith(EJBContainerRunner.class)
public class TestWebsocket {

    @Inject
    private WebSocket socket;

    @Test
    public void test() throws SocketException {
        String answer = socket.handleMessage("Java");
        assertThat(answer, is(equalTo("Hello Java!")));
    }   
}