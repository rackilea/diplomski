savedInstanceState = getIntent().getExtras();
String type = savedInstanceState.getString(TYPE);
if(type.equals("tree"))
{
    setContentView(R.layout.activity_sound_tree);
}
else
{
    TextView tv = (TextView) findViewById(R.id.heading_sound);
    tv.setText("'"+type+"'");
}