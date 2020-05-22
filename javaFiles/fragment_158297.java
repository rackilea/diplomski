public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
         super.onCreate (savedInstanceState);

         //stylize the action bar
         TextView tv = new TextView(getApplicationContext());
         RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams (ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
         tv.setLayoutParams(lp);
         tv.setText(R.string.Title);
         tv.setTextSize(45);
         tv.setTextColor(Color.parseColor("#FFFFFF"));
         Typeface tf = Typeface.createFromAsset(getAssets(), "KGALittleSwag.ttf");
         tv.setTypeface(tf);

         getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
         getSupportActionBar().setCustomView(tv);
         updateOptionsMenu();

    }
}