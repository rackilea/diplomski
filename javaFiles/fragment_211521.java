private void playSong(Uri uri) {
  // this is just example, don't expect the code to works.
  MediaPlayer mp = new MediaPlayer();
  mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
  mp.setDataSource(getApplicationContext(), uri);
  mp.prepare();
  mp.start();
  mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    public void onCompletion(MediaPlayer mPlayer) {
      // get the next uri here
      // assume there is next uri.
      playSong(nextUri);
    }
  });

}