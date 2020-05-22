@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game_screen);

    Random randomGenerator = new Random();
    int randomInt;

    rollButton = (Button) findViewById(R.id.rollButton);
    rollScore = (TextView) findViewById(R.id.rollScore);
    totalSCore = (TextView) findViewById(R.id.totalScore);



    rollButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                randomInt = randomGenerator.nextInt(7) + 1;
                rollScore.setText(Integer.toString(randomInt));
                mCounter++;

        }
    });

}