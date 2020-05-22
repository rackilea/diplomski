public class CheckableLinearLayout extends LinearLayout implements Checkable {
    RadioButton mRadioButton;

    public CheckableLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CheckableLinearLayout(Context context) {
        super(context);
    }

    public CheckableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        findCheckableView(this);
    }

    //finds RadioButton recursively (comment if you know a better way to do that)
    void findCheckableView(ViewGroup parent) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                findCheckableView((ViewGroup) child);
            } else if (child != null) {
                if (child instanceof RadioButton) {
                    mRadioButton = (RadioButton) child;
                }
            }
        }
    }

    @Override
    public void setChecked(boolean checked) {
        if (mRadioButton != null) {
            mRadioButton.setChecked(checked);
        }
    }

    @Override
    public boolean isChecked() {
        return mRadioButton != null ? mRadioButton.isChecked() : false;
    }

    @Override
    public void toggle() {
        if (mRadioButton != null) {
            mRadioButton.toggle();
        }
    }
}