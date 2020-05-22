public class TextSizeFilter implements InputFilter {
    Paint p;
    int maxWidth;

    /**
     * A filter based on the maxWidth of the text.
     * @param p Paint used by the View
     * @param maxWidth Max width of the text
     */
    public TextSizeFilter(Paint p, int maxWidth) {
        this.p = p;
        this.maxWidth = maxWidth;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        float originalW = p.measureText(dest, 0, dstart);
        float spaceLeft = maxWidth - originalW;

        if (spaceLeft > 0) {
            int w = p.breakText(source, start, end, true, spaceLeft, null);

            if (w != source.length())
                return source.subSequence(0, start + w);
        } else {
            return "";
        }

        return null;
    }
}