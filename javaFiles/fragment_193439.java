@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);   //moved up
    mview = findViewById(R.id.mview);       //moved down
    ScrollView scrollView = findViewById(R.id.scrollview);
    Button button = findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            clicked();
        }
    });
}