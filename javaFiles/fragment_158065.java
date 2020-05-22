protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btn = (Button) findViewById(R.id.btnEnter);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override


        public void onClick(View view) {
            Intent intent = new Intent
                    (MainActivity.this, LoginActivity.class);
            MainActivity.this.startActivity(intent);
        }
    });
}