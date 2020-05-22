public class MainActivity extends Activity {

    Typeface tf_r, tf_icon;
    Button reload;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int hexVal = Integer.parseInt("f021", 16);
        SpannableStringBuilder SS = new SpannableStringBuilder((char)hexVal + " Refresh");

        tf_r = Typeface.createFromAsset(this.getAssets(), "www/fonts/Roboto-Light.ttf");
        tf_icon = Typeface.createFromAsset(this.getAssets(), "www/fonts/fontawesome-webfont.ttf");

        SS.setSpan(new CustomTypefaceSpan("", tf_icon), 0, 1,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        SS.setSpan(new CustomTypefaceSpan("", tf_r), 1, 9,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        reload = (Button) findViewById(R.id.no_openings_reload);
        reload.setText(SS);
    }
}