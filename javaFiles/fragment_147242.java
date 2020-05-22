public void onPlayButtonClicked(View v) {
    ImageButton pb = (ImageButton) findViewById(R.id.song_play_button);
    if (!mediaPlayer.isPlaying()) {
        mediaPlayer.start();
        pb.setImageResource(R.drawable.pause);

        updateSeekBar();

    } else {
        mediaPlayer.pause();
        pb.setImageResource(R.drawable.ic_play_arrow_white_24dp);
    }
}