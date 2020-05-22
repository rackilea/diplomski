public class CustomTextView extends TextView{
    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initFont();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFont();
    }

    public CustomTextView(Context context) {
        super(context);
        initFont();
    }

    private void initFont() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"myfont.ttf");
        setTypeface(tf);
    }
}