//layout over the grid layout for playing again
private LinearLayout playAgainLayout;

//the winner message on the linear  layout
private TextView winnerMessage;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // layout is inflated, now we can find the views using findViewById
    playAgainLayout = (LinearLayout)findViewById(R.id.playAgainLayout);
    winnerMessage = (TextView)findViewById(R.id.winnerMessage);

    Log.i("Check if game starts :","Yes");
    }
}