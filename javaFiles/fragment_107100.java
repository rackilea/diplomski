int userScore;
private int[] diceArray = {R.drawable.d1, R.drawable.d2, R.drawable.d3,
        R.drawable.d4,R.drawable.d5,R.drawable.d6};

@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

}

public void onRollBtnClicked() {
    ImageView diceFace = (ImageView) findViewById(R.id.diceFaceImageView);
    userScore = randomIntegerGenerator(1,6); // this is what you need
    diceFace.setImageResource(diceArray[userScore]);

}

// function to return random integer from min to max
public int randomIntegerGenerator(int min, int max) {
     return random.nextInt((max - min) + 1) + min;
}