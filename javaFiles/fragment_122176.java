// define
Player player4 , player3,
        player2, player1;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ...
    etPlayer4 = (EditText) findViewById(R.id.etPlayer4);
    String namePlayer4 = etPlayer4.getText().toString();

    // assign
    player4 = new Player();
    player4.setPlayerName(namePlayer4);
    player4.setPlayerScore(0);

    btnStartGame = (Button) findViewById(R.id.btnStartGame);
    btnStartGame.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(CreatePlayersScreen.this,ScoreScreen.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("EXTRA_PLAYER_1", player1);
            bundle.putParcelable("EXTRA_PLAYER_2", player2);
            bundle.putParcelable("EXTRA_PLAYER_3", player3);
            bundle.putParcelable("EXTRA_PLAYER_4", player4);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    });
}