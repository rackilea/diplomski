@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    but1 = (Button) findViewById(R.id.but1);
    init();

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, "Replace with your own action",    
       Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    });
    .......
public void init() {

but1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent toy = new Intent(getApplicationContext(),  
 Main2Activity.class);

        startActivity(toy);

    }
});

}