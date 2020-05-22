@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button next = (Button) findViewById(R.id.synergia);
    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, Main3Activity.class);
            startActivity(intent);
        }
    });


    Button loadNewActivity = (Button) findViewById(R.id.dzwonki);
    loadNewActivity.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, Main4Activity.class);
            startActivity(intent);
        }
    });

}