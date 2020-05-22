public void sendNames() {
    //sends player1's name to mainGame
    Intent intent = new Intent (this, MainGame.class);
    EditText player1 = (EditText) findViewById(R.id.player1);
    String player1Name= player1.getText().toString();
    intent.putExtra("player1Name", player1Name);
    EditText player2 = (EditText) findViewById(R.id.player2);
    String player2Name= player2.getText().toString();
    intent2.putExtra("player2Name", player2Name);
    startActivity(intent);