public class UnixStylePrintWriter extends PrintWriter {
    @Override
    public void println() {
        write('\n');
    }
}