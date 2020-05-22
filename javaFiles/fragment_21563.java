ViewGroup container = findViewById(R.id.linearLayout);

for( int i = 0; i < numberOfPlayers; i++ ){
    EditText et = new EditText(this);
    et.setHint(R.string.new_player_hint);// String providing a hint to the user
    container.addView(et);
}