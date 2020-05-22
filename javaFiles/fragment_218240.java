public class FileBodyWithOffset implements Body {

    private final ReadableByteChannel channel;

    private long actualOffset;

    private final long contentLength;

    public FileBodyWithOffset(final File file, final long offset) throws IOException {

        final InputStream stream = new FileInputStream(file);

        this.actualOffset = stream.skip(offset);

        this.contentLength = file.length() - offset;

        this.channel = Channels.newChannel(stream);
    }


    public long getContentLength() {

        return this.contentLength;
    }

    public long read(ByteBuffer byteBuffer) throws IOException {

        System.out.println(new Date());

        actualOffset += byteBuffer.capacity();

        return channel.read(byteBuffer);
    }

    public void close() throws IOException {

        channel.close();
    }

    public long getActualOffset() {

        return actualOffset;
    }
}