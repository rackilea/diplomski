public class HebrewTextView extends LinearLayout
{
private TextView mTextView;

public HebrewTextView(Context context)
{
    super(context);
    init(null);
}

public HebrewTextView(Context context, AttributeSet attrs)
{
    super(context, attrs);
    init(attrs);
}

public TextView getTextView()
{
    return mTextView;
}

private void init(AttributeSet attrs)
{       
    mTextView = new TextView(getContext());
    LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
    lp.gravity = Gravity.RIGHT; 
    mTextView.setLayoutParams(lp);
    mTextView.setGravity(Gravity.CENTER_VERTICAL);

    addView(mTextView);

    if(attrs!=null)
    {
        TypedArray params = getContext().obtainStyledAttributes(attrs, R.styleable.HebrewTextView);
        mTextView.setText(params.getString(R.styleable.HebrewTextView_android_text));
        mTextView.setTextColor(params.getColor(R.styleable.HebrewTextView_android_textColor, Color.WHITE));
        mTextView.setTextSize(params.getDimension(R.styleable.HebrewTextView_android_textSize, 10));
        mTextView.setSingleLine(params.getBoolean(R.styleable.HebrewTextView_android_singleLine, false));
        mTextView.setLines(params.getInt(R.styleable.HebrewTextView_android_lines, 1));                     
        params.recycle();
    }               
}
}