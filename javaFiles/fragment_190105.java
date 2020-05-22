public class FileServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf buff) throws Exception {
        String filePathStr = buff.toString(CharsetUtil.UTF_8);

        File file = new File(filePathStr);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        ChannelFuture sendFileFuture;
        try {
            sendFileFuture = ctx.writeAndFlush(new ChunkedNioFile(raf.getChannel()), ctx.newProgressivePromise());
            sendFileFuture.addListener(new ChannelProgressiveFutureListener() {
                public void operationComplete(ChannelProgressiveFuture future) throws Exception {
                    System.err.println("Transfer complete.");
                    if (raf != null) {
                        raf.close();
                    }
                }
                public void operationProgressed(ChannelProgressiveFuture future, long progress, long total)
                        throws Exception {
                    if (total < 0) { // total unknown
                        System.err.println("Transfer progress: " + progress);
                    } else {
                        System.err.println("Transfer progress: " + progress + " / " + total);
                    }
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}