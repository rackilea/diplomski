protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    GameView gameView = (GameView) findViewById(R.id.game_view);
    Button button = (Button) findViewById(R.id.button);

    button.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            // respond to clicks
        }
    });
}