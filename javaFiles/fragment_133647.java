public abstract class LimitedRowFilter<M, I> extends RowFilter<M, I> {

    private int lineLimit;
    private int lineCount;

    public void reset() {
        lineCount = 0;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void incrementLineCount() {
        lineCount++;
    }

    public int getLineLimit() {
        return lineLimit;
    }

    public void setLineLimit(int lineLimit) {
        this.lineLimit = lineLimit;
    }

    public LimitedRowFilter(int lineLimit) {
        this.lineLimit = lineLimit;
    }

    public LimitedRowFilter() {
    }

}