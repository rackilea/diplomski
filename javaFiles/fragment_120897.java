public class ToggleImageView extends AppCompatImageView implements View.OnClickListener {
    private Drawable mLowDrawable, mHighDrawable;
    private boolean isLow = true;

    public ToggleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // Extract drawables from custom attributes
        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.ToggleImageView);
        setLowDrawable(values.getDrawable(R.styleable.ToggleImageView_low_img));
        setHighDrawable(values.getDrawable(R.styleable.ToggleImageView_high_img));
        values.recycle();

        setImageDrawable(mLowDrawable);

        super.setOnClickListener(this);
    }

    public void setLowDrawable(Drawable drawable) {
        mLowDrawable = drawable;

        if (isLow)
            setImageDrawable(mLowDrawable);
    }

    public void setHighDrawable(Drawable drawable) {
        mHighDrawable = drawable;

        if (!isLow)
            setImageDrawable(mHighDrawable);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        // Do nothing to block setting listener from outer caller
    }

    @Override
    public void onClick(View view) {
        toggle();
    }

    public void toggle() {
        isLow = !isLow;

        setImageDrawable(isLow ? mLowDrawable : mHighDrawable);
    }
}