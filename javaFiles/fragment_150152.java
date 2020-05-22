@Singleton
public class ExampleWebSocketServlet extends AbstractGuiceWebSocketServlet {

    @Override
    public Class<? extends StreamInbound> serveWith() {
        return Foo.class;
    }

    public static class Foo extends MessageInbound {

    @Inject GuiceCreatedAndInjected bar;

    @Override
    protected void onBinaryMessage(ByteBuffer byteBuffer) throws IOException {
        // do nothing
    }

    @Override
    protected void onTextMessage(CharBuffer charBuffer) throws IOException {
        // this getSwOutbonds() is not very friendly to testing
        getWsOutbound().writeTextMessage(bar.echo(charBuffer));
    }

   }
}