public class LimitedChannelSpeaker{
    Channel channel;
    final Object lock = new Object();
    long maxMemorySizeB;
    long size = 0;
    Map<ChannelBufferRef, Integer> buffer2readablebytes = new HashMap<ChannelBufferRef, Integer>();

    public LimitedChannelSpeaker(Channel channel, long maxMemorySizeB) {
        this.channel= channel;
        this.maxMemorySizeB = maxMemorySizeB;
    }

    public ChannelFuture speak(ChannelBuffer buff) {
        if (buff.readableBytes() > maxMemorySizeB) {
            throw new IndexOutOfBoundsException("The buffer is larger than the maximum allowed size of " + maxMemorySizeB + "B.");
        }
        synchronized (lock) {
            while (size + buff.readableBytes() > maxMemorySizeB) {
                try {
                    lock.wait();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            ChannelBufferRef ref = new ChannelBufferRef(buff);
            ref.register();
            ChannelFuture future = channel.write(buff);
            future.addListener(new ChannelBufferRef(buff));
            return future;
        }
    }

    private void spoken(ChannelBufferRef ref) {
        synchronized (lock) {
            ref.unregister();
            lock.notifyAll();
        }
    }

    private class ChannelBufferRef implements ChannelFutureListener {

        int readableBytes;

        public ChannelBufferRef(ChannelBuffer buff) {
            readableBytes = buff.readableBytes();
        }

        public void unregister() {
            buffer2readablebytes.remove(this);
            size -= readableBytes;
        }

        public void register() {
            buffer2readablebytes.put(this, readableBytes);
            size += readableBytes;
        }

        @Override
        public void operationComplete(ChannelFuture future) throws Exception {
            spoken(this);
        }
    }
}