public class TabbedPrintWriter extends PrintWriter {

    private static int indentAmount = 4;
    private int indent = 0;
    private StringBuilder line = new StringBuilder();

    public TabbedPrintWriter(OutputStream out) {
        super(out);
    }

    public TabbedPrintWriter(OutputStream out, boolean autoFlush) {
        super(out, autoFlush);
    }

    @Override
    public void println() {
        for (int i = 0; i < indentAmount * indent; i++)
            line.insert(0, ' ');
        super.write(line.toString(), 0, line.length());
        line = new StringBuilder();
        super.println();
    }

    @Override
    public void write(int c) {
        line.append((char) c);
    }

    @Override
    public void write(String s, int off, int len) {
        line.append(s, off, len);
    }

    @Override
    public void write(char[] buf, int off, int len) {
        line.append(buf, off, len);
    }

    public void indent() {
        indent++;
    }

    public void unindent() {
        indent--;
    }
}