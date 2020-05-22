public class IoUtil {

    private static final int bufferSize = 8192;

    public static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[bufferSize];
        int read;

        while ((read = in.read(buffer, 0, bufferSize)) != -1) {
            out.write(buffer, 0, read);
        }
    }
}