public class DeviceReader implements Closeable {
    private final RandomAccessFile file;
    private final byte[] buf = new byte[512];

    public DeviceReader(String fileName) throws IOException {
        this.file = new RandomAccessFile(fileName, "r");
    }

    @Override
    public void close() throws IOException {
        file.close();
    }

    public synchronized double readDouble() throws IOException {
        file.seek(0);
        int length = file.read(buf);
        if (length <= 0) {
            throw new EOFException();
        }

        int sign = 1;
        long exp = 0;
        long value = 0;

        for (int i = 0; i < length; i++) {
            byte ch = buf[i];
            if (ch == '-') {
                sign = -1;
            } else if (ch == '.') {
                exp = 1;
            } else if (ch >= '0' && ch <= '9') {
                value = (value * 10) + (ch - '0');
                exp *= 10;
            } else if (ch < ' ') {
                break;
            }
        }

        return (double) (sign * value) / Math.max(1, exp);
    }
}