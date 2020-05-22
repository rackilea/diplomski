import android.media.MediaPlayer;
...
myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
  @Override
  public void onCompletion(MediaPlayer arg0) {
    // restart on completion
    myVideoView.start();
  }
});
...
myVideoView.start();
...