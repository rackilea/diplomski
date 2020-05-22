@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    int ok=47;
    String name="info"+ok;
    TextView infotextView= (TextView) findViewById(R.id.textView);
    infotextView.setText(getStringByName(this,name));
}

public static String getStringByName(Context context, String name) {
    Resources res = context.getResources();
    return res.getString(res.getIdentifier(name, "string", context.getPackageName()));
}