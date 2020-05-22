protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    seekBar = (SeekBar)findViewById(R.id.seekBar);
    txtMode= (TextView) findViewById(R.id.txtMode);
    btnPlay = (Button)findViewById(R.id.btnPlay);
    btnScore = (Button)findViewById(R.id.btnScore);

    db = new DbHelper(this);
}