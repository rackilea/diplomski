Activity activity;
View v;
public View onCreate(Activity activity)//change the name if you want
 {
    this.activity = activity;
    Typeface rt=Typeface.createFromAsset(getAssets(),"font/Carleton.ttf");
    //super.onCreate(savedInstanceState);
    //setContentView(R.layout.wallpaper);
    LayoutInflator li = activity.getLauoutInflator();
    v = li.inflate(R.layout.wallpaper, null);
    .
    .
    .
    return v;
}