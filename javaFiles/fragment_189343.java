private Button fiveMinuteButton;
 int circuitLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_workout_settings_screen);


    Toast.makeText(this,"circuitLength value ="+circuitLength, Toast.LENGTH_LONG).show();
    fiveMinuteButton = (Button) findViewById(R.id.fiveminutesbuttonid);
    fiveMinuteButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            circuitLength = 5;
            Toast.makeText(ACtivityName.this,"circuitLength value ="+circuitLength, Toast.LENGTH_LONG).show();

        }
    });