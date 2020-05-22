public class MyButton extends RelativeLayout {

    private TextView mTextView;
    private ImageView mImageView;

    public MyButton(Context context) {
        super(context);
        init(context, null);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.my_button, this, true); // used with merge tag
        mTextView = (TextView) findViewById(R.id.text);
        mImageView = (ImageView) findViewById(R.id.image);

        int[] attrs = {android.R.attr.text};
        TypedArray a = context.obtainStyleAttributes(attributeSet, attrs);
        String text = a.getString(0, null);
        mTextView.setText(text);
        a.recycle();
    }
}