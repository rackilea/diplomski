class IOUtils {
    private static final int BUFFER_SIZE = 1024 * 4;

    public static long copy(InputStream input, OutputStream output)
            throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE];
        long count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    public static void closeQuietly(Closeable output) {
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}