//ProtocolCatcher
//...

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //...

    Intent gameIntent = new Intent(this, MainActivity.class);
    /*
        //Pass the extra data to the game if needed
        Intent sourceIntent = getIntent();
        Uri data = sourceIntent.getData();
        gameIntent.putExtra("uriData", data != null ? data.toString(): null); 
    */
    startActivity(gameIntent); //start the real game
    finish(); //close the ProtocolCatcher activity

}