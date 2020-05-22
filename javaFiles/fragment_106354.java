public class FormattingRun {
    private int beginIdx;
    private int length;
    private short fontIdx;
    public FormattingRun(int beginIdx, int length, short fontIdx) {
        this.beginIdx = beginIdx;
        this.length = length;
        this.fontIdx = fontIdx;
    }
    public int getBegin() { return beginIdx; }
    public int getLength() { return length; }
    public short getFontIndex { return fontIdx; }
}