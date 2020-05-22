public class SentenceReaderHandler extends
         SimpleChannelInboundHandler<String> {
    private SentenceFactory factory;
    private SentenceReader parent;

    public SentenceReaderHandler (SentenceReader parent) {
        this.parent = parent;
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) {
        if(!ctx.channel().isActive())
            return;
        //ActivityMonitor monitor = new ActivityMonitor(parent);
        this.factory = SentenceFactory.getInstance();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        //ActivityMonitor monitor = new ActivityMonitor(parent);
        this.factory = SentenceFactory.getInstance();
    }

    @Override
    // This method will be renamed to `messageReceived` in Netty 5.0.0
    protected void channelRead0(ChannelHandlerContext ctx, String data)
             throws Exception {
        if (SentenceValidator.isValid(data)) {
            monitor.refresh();
            Sentence s = factory.createParser(data);
            parent.fireSentenceEvent(s);
        } else if (!SentenceValidator.isSentence(data)) {
            parent.fireDataEvent(data);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        //monitor.reset();
        parent.fireReadingStopped();
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) {
        if(!ctx.channel().isActive())
            return;
        //monitor.reset();
        parent.fireReadingStopped();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable e) {
        parent.handleException("Data read failed", e);
    }
}