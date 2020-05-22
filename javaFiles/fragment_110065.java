String videoSource = "http://173.193.24.66/~kanz/video/mp4/9.mp4";

myVideoView.setMediaController(new MediaController(this));
myVideoView.setVideoPath(videoSource);
myVideoView.requestFocus();
myVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
  public void onPrepared(MediaPlayer mp) {
    myVideoView.start();
  }
});