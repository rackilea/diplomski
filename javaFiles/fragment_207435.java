public class CustomFont {

    private Typeface typeface;
    public CustomFont(Context context) {
        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Slabo.ttf");
    }
    public void setFont(TextView textView) {
        textView.setTypeface(typeface);
    }
}