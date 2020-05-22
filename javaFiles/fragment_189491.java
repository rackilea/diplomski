@Sharable
    public class NettyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

        @Override
        public void channelRead0(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
            String message = byteBuf.toString(Charset.defaultCharset());
            System.out.println("Received Message : " + message);
        }

        @Override
        public void channelActive(ChannelHandlerContext channelHandlerContext){
            channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer("Netty Rocks!", CharsetUtil.UTF_8));
        }

    }