public class FontMetricsWrapper extends FontMetrics {

    private final FontMetrics target;

    public FontMetricsWrapper(FontMetrics target) {
        super(target.getFont());
        this.target = target;
    }

    @Override
    public int bytesWidth(byte[] data, int off, int len) {
        return target.bytesWidth(data, off, len);
    }

    @Override
    public int charWidth(char ch) {
        return target.charWidth(ch);
    }

    @Override
    public int charWidth(int codePoint) {
        return target.charWidth(codePoint);
    }

    // ... tons more @Override's, all of the same form:
    //
    // @Override
    // public baz foo(bar, ...) {
    //     return target.foo(bar, ...);
    // }

}