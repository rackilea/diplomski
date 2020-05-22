public class IconImageView extends ImageView {

    public IconImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(h != oldh && h > 0)
            getLayoutParams().width = h;  // same width as height
    }
}