ColorStateList primaryColor;

public PasswordStrengthBar(Context context, AttributeSet attrs) {
    super(context, attrs);

    try{
        primaryColor = a.getColorStateList(
            R.styleable.MyView_primary_color);
    }finally {
        a.recycle();
    }
}