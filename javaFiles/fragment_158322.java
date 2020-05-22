@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fifth_layout);
    Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            startActivity(new Intent(this, ThirdActivity.class));
        }
    });
}