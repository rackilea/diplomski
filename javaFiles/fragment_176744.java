public final class Closer
    implements Closeable
{
    private final List<Closeable> closeables = new ArrayList<Closeable>();

    // @Nullable is a JSR 305 annotation
    public <T extends Closeable> T add(@Nullable final T closeable)
    {
        closeables.add(closeable);
        return closeable;
    }

    public void closeQuietly()
    {
        try {
            close();
        } catch (IOException ignored) {
        }
    }

    @Override
    public void close()
        throws IOException
    {
        IOException toThrow = null;
        final List<Closeable> l = new ArrayList<Closeable>(closeables);
        Collections.reverse(l);

        for (final Closeable closeable: l) {
            if (closeable == null)
                continue;
            try {
                closeable.close();
            } catch (IOException e) {
                if (toThrow == null)
                    toThrow = e;
            }
        }

        if (toThrow != null)
            throw toThrow;
    }
}

// Copy one file to another using NIO
public static void doCopy(final File source, final File destination)
    throws IOException
{
    final Closer closer = new Closer();
    final RandomAccessFile src, dst;
    final FileChannel in, out;

    try {
        src = closer.add(new RandomAccessFile(source.getCanonicalFile(), "r");
        dst = closer.add(new RandomAccessFile(destination.getCanonicalFile(), "rw");
        in = closer.add(src.getChannel());
        out = closer.add(dst.getChannel());
        in.transferTo(0L, in.size(), out);
        out.force(false);
    } finally {
        closer.close();
    }
}