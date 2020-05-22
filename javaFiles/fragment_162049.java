...
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cashView = (TextView) findViewById(R.id.cashView);
        levelView = (TextView) findViewById(R.id.levelView);
        loadGame( );

    }
     public void loadGame() {
        SharedPreferences loadGame = getSharedPreferences(PREFS, MODE_PRIVATE);
        cash = loadGame.getInt("savedCash", 1000);
        level = loadGame.getInt("savedLevel", 1);
        cashView.setText("Cash: " + String.valueOf(cash));
        levelView.setText("Level: " + String.valueOf(level));
      }