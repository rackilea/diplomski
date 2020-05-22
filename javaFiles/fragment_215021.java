public class OutputStreamNetty extends OutputStream {
    final Channel channel = ...;
    ChannelFuture lastFuture;

    private void checkFuture() throws IOException {
        if(lastFuture.isDone()) {
            if(lastFuture.cause() != null) {
                throw new IOException("Downstream write problem", lastFuture.cause() );
            }
            lastFuture = null;
        }
    }

    private void addFuture(ChannelFuture f) {
        if(lastFuture == null) {
            lastFuture = f;
        }
    }

    public void close() throws IOException {
        checkFuture()
        addFuture(channel.close());
    }
    public void flush() throws IOException {
        checkFuture()
        addFuture(channel.flush());
    }
    public void write(byte[] b, int off, int len) throws IOException {
        checkFuture()
        Bytebuf f = channel.alloc().buffer(len);
        f.writeBytes(b, off, len);
        addFuture(channel.write(f));
    }
    public abstract void write(int b) throws IOException {
        checkFuture()
        Bytebuf f = channel.alloc().buffer(1);
        f.writeByte(b);
        addFuture(channel.write(f));
    }

}