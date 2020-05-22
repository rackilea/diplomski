import java.io.IOException;
    import java.io.RandomAccessFile;
    import java.nio.channels.FileChannel;

    public class Test {

        public static void main(final String[] args) throws Exception {
            final RandomAccessFile fromFile = new RandomAccessFile("d:/pp.dat", "rw");
            final FileChannel fromChannel = fromFile.getChannel();

            final RandomAccessFile toFile = new RandomAccessFile("d:/out.dat", "rw");
            final FileChannel toChannel = toFile.getChannel();

            final long position = 0;
            final long count = fromChannel.size();
            final Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        fromChannel.transferTo(position, count, toChannel);
                    } catch (final IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            final Thread t = new Thread(r);
            t.start();
            t.interrupt();
        }
    }