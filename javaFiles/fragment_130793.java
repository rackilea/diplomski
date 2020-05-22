public class KcsMultiAutoCompleteTextView extends MultiAutoCompleteTextView {
    public KcsMultiAutoCompleteTextView(Context context) {
        super(context);
    }

    public KcsMultiAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KcsMultiAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void performFiltering(CharSequence text, int start, int end, int keyCode) {
        if (text.charAt(start) == '@') {
            start = start + 1;
        } else {
            text = text.subSequence(0, start);
            for (int i = start; i < end; i++) {
                text = text + "*";
            }
        }
        super.performFiltering(text, start, end, keyCode);
    }

}