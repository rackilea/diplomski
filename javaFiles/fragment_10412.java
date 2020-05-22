public class SVButton extends Button {
    private Context mContext;

    public SVButton(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public SVButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public SVButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        this.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        this.setText("Push Me");
    }
}