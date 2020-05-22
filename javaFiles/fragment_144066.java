private int count = 0; // Global array index. Make it as class field   

final ArrayList<String> players = extrasBundle.getStringArrayList("playerList");



mPlayer = (TextView)findViewById(R.id.ZaidejoVardas);
players.size();

mPlayer.setText(players.get(0));




mNext = (Button)findViewById(R.id.KitasBtn);
mNext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        count++;
        mPlayer.setText(players.get((count)%players.size())); //Incrementing global count and making sure it never exceeds the players list size


    }
});