protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    next = (Button) findViewById(R.id.buttonnext);
    next.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    });
}