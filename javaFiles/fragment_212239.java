@Override
public void channelInactive(ctx) {
    System.out.println("I want to close fileoutputstream!");
    fos.close();
}

@Override
public void channelRead(ChannelHandlerContext ctx, Object msg)
        throws Exception {
    try {
        ByteBuf buf = (ByteBuf) msg;
        // if (buf.isReadable()) { // a buf should always be readable here
            buf.readBytes(fos, buf.readableBytes());
        //    fos.flush(); // flushing is always done when closing
        //} else {
        //    System.out.println("I want to close fileoutputstream!");
        //    buf.release(); // Should be placed in the finally block
        //    fos.flush();
        //    fos.close();
        //}
    } catch (Exception e) {
         e.printStackTrace();
    } finally {
         buf.release(); // Should always be done, even if writing to the file fails
    }
}