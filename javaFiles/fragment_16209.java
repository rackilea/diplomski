Typeface Rezvan,DroidNaskh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//Typography
    Rezvan = Typeface.createFromAsset(getAssets(), "fonts/rezvan.ttf");
    DroidNaskh = Typeface.createFromAsset(getAssets(), "fonts/droid_naskh.ttf");