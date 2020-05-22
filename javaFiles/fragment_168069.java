public CustomBar(Context context, AttributeSet attrs, int defStyle)
{
    super(context, attrs, defStyle);
    if(attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height").equals(String.valueOf(LayoutParams.WRAP_CONTENT)))
        useDefault = true;
    p.setColor(progColor);
}