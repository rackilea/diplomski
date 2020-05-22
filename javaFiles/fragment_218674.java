public class EmailTextView extends TextView {

    public EmailTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // the width the text can use, that is the total width of the view minus
        // the padding
        int availableWidth = w - getPaddingLeft() - getPaddingRight();
        String text = getText().toString();
        if (text.contains("\n@")) {
            // the text already contains a line break before @
            return;
        }
        // get the position of @ in the string
        int position = -1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '@') {
                position = i;
                break;
            }
        }
        if (position > 0) {
            final Paint pnt = getPaint();
            // measure width before the @ and after the @
            String beforeAt = text.subSequence(0, position).toString();
            String afterAt = text.subSequence(position + 1, text.length())
                    .toString();
            final float beforeAtSize = pnt.measureText(beforeAt);
            final float afterAtSize = pnt.measureText(afterAt);
            final float atSize = pnt.measureText("@");
            if (beforeAtSize > availableWidth) {
                // the text before the @ is bigger than the width
                // so Android will break it
                return;
            } else {
                if ((beforeAtSize + afterAtSize + atSize) <= availableWidth) {
                // the entire text is smaller than the available width
                    return;
                } else {
                    // insert the line break before the @
                    setText(beforeAt + "\n@" + afterAt);
                }
            }
        }
    }
}