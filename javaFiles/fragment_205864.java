public class TrafficInterceptorHandler extends ChannelInboundHandlerAdapter {

    public static final String NAME = "trafficInterceptor";
    private static Logger LOG = LoggerFactory.getLogger(TrafficInterceptorHandler.class);

    private AtomicInteger readBytes = new AtomicInteger(0);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) msg;
            readBytes.addAndGet(byteBuf.readableBytes());
        } else {
            LOG.warn("Received msg is not a ByteBuffer. Actual class: " + msg.getClass());
        }
        ctx.fireChannelRead(msg);
    }
    public int getReadBytes() {
        return readBytes.get();
    }
}