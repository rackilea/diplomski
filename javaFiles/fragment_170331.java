public class URLEncodedWriter extends FilterWriter {
    public void write(int c) {
        out.write(URLEncoder.encode((char)c, "UTF-8"));
    }
    ... // Same for 2 other write() methods
}