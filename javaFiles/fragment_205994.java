Button startB = null;
Button pauseB = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    startB = (Button) findViewById(R.id.startButton);
    pauseB = (Button) findViewById(R.id.pauseButton);
}

public void beginGame(View v)
{
    startB.setVisibility(View.GONE);
    pauseB.setVisibility(View.VISIBLE);

    // rest of method...
}