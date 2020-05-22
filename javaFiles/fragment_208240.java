public class NettyServer implements Processor {

private final ChannelGroup channelGroup = new DefaultChannelGroup();
private NioServerSocketChannelFactory serverSocketChannelFactory = null;
private final ExecutorService executor = Executors.newCachedThreadPool();

private String listenAddress = "0.0.0.0"; // overridden by spring-osgi value
private int listenPort = 51501; // overridden by spring-osgi value

@Override
public void process(Exchange exchange) throws Exception {
    byte[] bytes = (byte[]) exchange.getIn().getBody();
    // send over the wire
    sendMessage(bytes);
}

public synchronized void sendMessage(byte[] message) {
    ChannelBuffer cb = ChannelBuffers.copiedBuffer(message);
    //writes to all clients connected.
    this.channelGroup.write(cb);
}

private class NettyServerHandler extends SimpleChannelUpstreamHandler {

    @Override
    public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelOpen(ctx, e);
        //add client to the group.
        NettyServer.this.channelGroup.add(e.getChannel());

    }

    // Perform an automatic recon.
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelConnected(ctx, e);
        // do something here when a clien connects.
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        // Do something when a message is received...
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
        // Log the exception/
    }

}

private class PublishSocketServerPipelineFactory implements ChannelPipelineFactory {

    @Override
    public ChannelPipeline getPipeline() throws Exception {
        // need to set the handler.
        return Channels.pipeline(new NettyServerHandler());
    }
}

// called by spring to start the server
public void init() {

    try {
        this.serverSocketChannelFactory = new NioServerSocketChannelFactory(this.executor, this.executor);
        final ServerBootstrap serverBootstrap = new ServerBootstrap(this.serverSocketChannelFactory);
        serverBootstrap.setPipelineFactory(new PublishSocketServerPipelineFactory());
        serverBootstrap.setOption("reuseAddress", true);
        final InetSocketAddress listenSocketAddress = new InetSocketAddress(this.listenAddress, this.listenPort);
        this.channelGroup.add(serverBootstrap.bind(listenSocketAddress));

    } catch (Exception e) {

    }
}

// called by spring to shut down the server.
public void destroy() {

    try {
        this.channelGroup.close();
        this.serverSocketChannelFactory.releaseExternalResources();
        this.executor.shutdown();
    } catch (Exception e) {
    }
}

// injected by spring
public void setListenAddress(String listenAddress) {
    this.listenAddress = listenAddress;
}

// injected by spring
public void setListenPort(int listenPort) {
    this.listenPort = listenPort;
}