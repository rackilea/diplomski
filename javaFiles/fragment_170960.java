public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        if(msg.getMethod().equals(HttpMethod.POST) || msg.getMethod().equals(HttpMethod.PUT)) {
            System.out.println(msg.content().toString(Charset.forName("UTF-8")));
        }
    }
}