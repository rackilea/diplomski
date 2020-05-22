@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);

    //Retrieve the reference
    imageSwitcher = findViewById(R.id.imageSwitcher);
    textView = findViewById(R.id.textView);
    textViewScore = findViewById(R.id.textViewScore);
    textViewScore.setText(String.valueOf(livesRemaining));


    // ** QUICK FIX **
    btn = new Button[26];
    strText = "";

    setupImageSwitcher();
    setup26Buttons();
    getSecretWord();
}