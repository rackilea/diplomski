public void replayLevel() {
    replay = (ImageButton) findViewById(R.id.replay);
    Intent intent= getIntent();
    activity = intent.getStringExtra("activity");
    replay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View paramView) {
            if(activity.equals("level2")){
                Intent intent = new Intent(getApplicationContext(), com.creatives.arfa.revealthesecretsgame.HouseLevel2.class);
                startActivity(intent);
            }

            else if(activity.equals("level1")){
                Intent intent = new Intent(getApplicationContext(), com.creatives.arfa.revealthesecretsgame.Houselevel1.class);
                startActivity(intent);
            }
        }
    });
}