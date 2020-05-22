MediaPlayer mediaPlayer;

public void react(View view) {
    mediaPlayer = MediaPlayer.create(ToBeOrNot.this, R.raw.achord);
    mediaPlayer.start(); 
}

protected void onStop(){
    mediaPlayer.release();
    mediaPlayer = null;
}