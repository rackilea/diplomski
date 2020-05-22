@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final TextView line = (TextView) findViewById(R.id.line);
    Button bl = (Button) findViewById(R.id.bl);

    final String[] jokes = { 
        "joke 1", "joke 2" , "joke 3" , "joke 4"     
    };

    bl.setOnClickListener(new View.OnClickListener() {
        int rando = (int) (Math.random() * 4);
        @Override
        public void onClick(View v) {
            line.setText(jokes[rando]);

        }
    });
}