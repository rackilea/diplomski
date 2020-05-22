public class BackwardsReader implements Closeable {

    private static final int BUFFER_SIZE = 4096;

    private String charset;
    private RandomAccessFile raf;
    private long position;
    private int readIndex;
    private byte[] buffer = new byte[BUFFER_SIZE];

    /**
     * @param file a text file.
     * @param charset with bytes '\r' and '\n' (no wide chars).
     */
    public BackwardsReader(File file, String charset) throws IOException {
        this.charset = charset;
        raf = new RandomAccessFile(file, "r");
        position = raf.length();
    }

    public String readLine() throws IOException {
        if (position + readIndex == 0) {
            raf.close();
            raf = null;
            return null;
        }

        String line = "";
        for (;;) { // Loop adding blocks without newline '\n'.

            // Search line start:

            boolean lineStartFound = false;
            int lineStartIndex = readIndex;
            while (lineStartIndex > 0) {
                if (buffer[lineStartIndex - 1] == (byte)'\n') {
                    lineStartFound = true;
                    break;
                }
                --lineStartIndex;
            }
            String line2;
            try {
                line2 = new String(buffer, lineStartIndex, readIndex - lineStartIndex,
                        charset).replaceFirst("\r?\n?", "");
                readIndex = lineStartIndex;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(BackwardsReader.class.getName())
                        .log(Level.SEVERE, null, ex);
                return null;
            }
            line = line2 + line;
            if (lineStartFound) {
                --readIndex;
                break;
            }

            // Read a prior block:

            int toRead = BUFFER_SIZE;
            if (position - toRead < 0) {
                toRead = (int) position;
            }
            if (toRead == 0) {
                break;
            }
            position -= toRead;
            raf.seek(position);
            raf.readFully(buffer, 0, toRead);
            readIndex = toRead;
            if (buffer[readIndex - 1] == (byte)'\r') {
                --readIndex;
            }
        }
        return line;
    }

    @Override
    public void close() throws IOException {
        if (raf != null) {
            raf.close();
        }
    }
}