public class HelveticaTextView extends TextView{
    public HelveticaTextView(Context c){
        Typeface Helvetica = Typeface.createFromAsset(c.getAssets(), "fonts/Helvetica.otf");
        super(c);
        this.setTypeface(Helvetica);
    }
    public HelveticaTextView(Context c, AttributeSet attrs){
    Typeface Helvetica = Typeface.createFromAsset(c.getAssets(), "fonts/Helvetica.otf");
        super(c, attrs);
        this.setTypeface(Helvetica);
    }
    public HelveticaTextView(Context context, AttributeSet attrs, int defStyle) {
    Typeface Helvetica = Typeface.createFromAsset(c.getAssets(), "fonts/Helvetica.otf");
        super(c, attrs, defStyle);
        this.setTypeface(Helvetica);
    }
}