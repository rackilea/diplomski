Intent intent = new Intent(MainActivity.this, MainActivity1.class);

//or
Intent intent = new Intent(v.getContext(), MainActivity1.class);

//or, define a global variable in your Activity, outside the onClick:
Context context;
//in onCreate:
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    pref = getPreferences(0);
    setContentView(R.layout.activity_main);
    context = this;
    //your other code...

// in onClick:
addsub.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        Intent intent = new Intent(context, MainActivity1.class);
        startActivity(intent);
    }
});