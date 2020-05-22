public class DynamicFontTextView extends TextView {

    public DynamicFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        updateActiveFont();
    }

    public DynamicFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        updateActiveFont();
    }

    public DynamicFontTextView(Context context) {
        super(context);
        updateActiveFont();
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        // if(style == Typeface.BOLD) <-- Something for later
        super.setTypeface(FontHolder.getInstance().getActiveFont());
    }

    public void updateActiveFont(){
        super.setTypeface(FontHolder.getInstance().getActiveFont());
    }
}