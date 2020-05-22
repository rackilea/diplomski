final Button play = (Button) findViewById(R.id.play);
boolean isPlaying = false;
play.setOnClickListener(new View.OnClickListener(){
    @Override
        public void onClick(View view){
        if (isPlaying) {
           play.setText("Pause");
           isPlaying = false;
           //ADD CODE TO PAUSE HERE
        } else {
           play.setText("Play");
           isPlaying = true;
           //ADD CODE TO PLAY HERE
        }
    }
});