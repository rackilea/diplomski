@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button button2 = (Button) findViewById(R.id.button2);
    button2.setOnClickListener(new OnClickListener() {          

    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(), MainActivity2.class));
        finish();
    }  
    getActionBar().setDisplayHomeAsUpEnabled(true);
}