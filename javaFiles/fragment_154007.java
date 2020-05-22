public class BlockInputStream extends InputStream {
    private final BufferedInputStream inputStream;
    private final long totalLength;
    private final long skip;
    private long read = 0;
    private byte[] buff = new byte[16];
    private ByteArrayInputStream blockInputStream;

    public BlockInputStream(InputStream inputStream, long skip, long length) throws IOException {
        this.inputStream = new BufferedInputStream(inputStream);
        this.skip = skip;
        this.totalLength = length + skip;
        if(skip > 0) {
            byte[] b = new byte[(int)skip];
            read(b);
            b = null;
        }
    }


    private int readBlock() throws IOException {
        int count = inputStream.read(buff);
        blockInputStream = new ByteArrayInputStream(buff);
        return count;
    }

    @Override
    public int read () throws IOException {
        byte[] b = new byte[1];
        read(b);
        return (int)b[1];
    }

    @Override
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override
    public int read (byte[] bytes, int offset, int length) throws IOException {
        long remaining = totalLength - read;
        if(remaining < 1){
            return -1;
        }
        int bytesToRead = (int)Math.min(length, remaining);
        int n = 0;
        while(bytesToRead > 0){
            if(read % 16 == 0 && bytesToRead % 16 == 0){
                int count = inputStream.read(bytes, offset, bytesToRead);
                read += count;
                offset += count;
                bytesToRead -= count;
                n += count;
            } else {
                if(blockInputStream != null && blockInputStream.available() > 0) {
                    int len = Math.min(bytesToRead, blockInputStream.available());
                    int count = blockInputStream.read(bytes, offset, len);
                    read += count;
                    offset += count;
                    bytesToRead -= count;
                    n += count;
                } else {
                    readBlock();
                }
            }
        }
        return n;
    }

    @Override
    public int available () throws IOException {
        long remaining = totalLength - read;
        if(remaining < 1){
            return -1;
        }
        return inputStream.available();
    }

    @Override
    public long skip(long n) throws IOException {
        return inputStream.skip(n);
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }

    @Override
    public synchronized void mark(int readlimit) {
        inputStream.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        inputStream.reset();
    }

    @Override
    public boolean markSupported() {
        return inputStream.markSupported();
    }
}