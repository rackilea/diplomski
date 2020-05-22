int rando; // store in a field in your Activity
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final TextView line = (TextView) findViewById(R.id.line);
    Button bl = (Button) findViewById(R.id.bl);

    final String[] jokes = { 
        "joke 1", "joke 2" , "joke 3" , "joke 4"     
    };
    final int jokeCount = jokes.length;
    rando = (int) (Math.random() * 4); // initialize only in onCreate

    bl.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (++rando >= jokeCount) { // increment in onClick
                rando = 0;              // reset counter when needed
            }
            line.setText(jokes[rando]);
        }
    });
}