private int clicks = 0;
    private TextView textCount;
    private ImageButton buttonCount;
    private int guessCount = 0;  
    private CountDownTimer count; // RENAMED     
    private boolean started = false; // FALSE. 
    private boolean timerProcessing = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newgame);

        count = new CountDownTimer(15000, 1000) { // MOVED UP
            public void onTick(long millisUntilFinished) {
                int seconds = (int) ((millisUntilFinished / 1000));
                textic.setText("Time Left: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textic.setText("Time's Up!");
                buttonCount.setEnabled(false);
                if (clicks > oldscore)
                    getSharedPreferences("myPrefs", MODE_PRIVATE).edit().putInt("highscore", clicks).commit();
            }
        };


        final int oldscore = getSharedPreferences("myPrefs", MODE_PRIVATE).getInt("highscore", 0);
        final TextView textView = (TextView) findViewById(R.id.applesEaten);

        buttonCount = (ImageButton) findViewById(R.id.button);
        buttonCount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                clicks++;
                textView.setText("Clicks: " + clicks);
                TextView textView = (TextView) findViewById(R.id.topScoreView);
                textView.setText("Best: " + oldscore);

                if(!started){
                    count.start(); // START COUNTDOWN TIMER
                    started = true;
                    timerProcessing = true;

                }

            }
        });
        final TextView textic = (TextView) findViewById(R.id.textView2);


    }