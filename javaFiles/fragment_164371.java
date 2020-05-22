final class IOUtil {
    public static String read(Reader in, int len) throws IOException {
        char[] buf = new char[len];
        int charsRead = in.read(buf);
        return (charsRead == -1 ? null : new String(buf, 0, charsRead));
    }
}