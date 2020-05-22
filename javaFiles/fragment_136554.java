Button button;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);

getSupportActionBar().setDisplayHomeAsUpEnabled(true);
setContentView(R.layout.activity_preferences);

donate = (ImageView) findViewById(R.id.button_donate);
donate.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        donate(v);
    }
});


button = (Button) findViewById(R.id.button_visualhelp);
button.setOnClickListener(new OnClickListener() {
    public void onClick(View arg0) {
Intent myIntent = new Intent(PreferencesAtivity.this,
    VisualHelpActivity.class);
    startActivity(myIntent);
    }
});
Spinner s = (Spinner) findViewById(R.id.combo_language);
Lang[] languages = LanguageUtil.Lang.values();

s.setAdapter(new ArrayAdapter<Lang>(this,
        android.R.layout.simple_dropdown_item_1line, languages));
s.setSelection(getPosition(languages, LanguageUtil.getLanguage()), true);
}